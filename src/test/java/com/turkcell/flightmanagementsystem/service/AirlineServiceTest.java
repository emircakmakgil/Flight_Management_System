package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.dto.airline.AirlineListiningDto;
import com.turkcell.flightmanagementsystem.dto.airline.CreateAirlineDto;
import com.turkcell.flightmanagementsystem.entity.Airline;
import com.turkcell.flightmanagementsystem.repository.AirlineRepository;
import com.turkcell.flightmanagementsystem.service.impl.AirlineServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.List;
import java.util.UUID;

public class AirlineServiceTest {
    private AirlineService airlineService;
    private AirlineRepository airlineRepository;

    @Before
    public void setUp() {
        // 1. Repository'yi mock olarak oluşturuyoruz
        airlineRepository = Mockito.mock(AirlineRepository.class);

        // 2. Test edeceğimiz servisin gerçek implementasyonunu kullanıyoruz
        // ve mock repository'yi enjekte ediyoruz
        airlineService = new AirlineServiceImpl(airlineRepository);
    }

    @Test
    public void whenAddCalledWithValidRequest_itShouldSaveAirlineToRepository() {
        // 1. ARRANGE - Test verisini hazırlama
        CreateAirlineDto createAirlineDto = new CreateAirlineDto();
        createAirlineDto.setName("Turkish Airlines");
        createAirlineDto.setCode("TK");
        createAirlineDto.setCountry("Turkey");

        // 2. ACT - Test edilecek metodu çağırma
        airlineService.add(createAirlineDto);

        // 3. ASSERT - Beklenen davranışı doğrulama
        // Repository'nin save metodu çağrıldı mı kontrol ediyoruz
        verify(airlineRepository, times(1)).save(any(Airline.class));
    }

    @Test
    public void whenGetAllCalled_itShouldReturnAirlineList() {
        // 1. ARRANGE - Test verisini ve mock davranışını hazırlama
        // Mock repository'nin findAll çağrısına cevap olarak örnek veri döndürüyoruz
        Airline airline1 = new Airline();
        airline1.setId(UUID.randomUUID());
        airline1.setName("Turkish Airlines");
        airline1.setCode("TK");
        airline1.setCountry("Turkey");

        Airline airline2 = new Airline();
        airline2.setId(UUID.randomUUID());
        airline2.setName("Pegasus Airlines");
        airline2.setCode("PC");
        airline2.setCountry("Turkey");

        Mockito.when(airlineRepository.findAll()).thenReturn(List.of(airline1, airline2));

        // 2. ACT - Test edilecek metodu çağırma
        List<AirlineListiningDto> result = airlineService.getAll();

        // 3. ASSERT - Beklenen davranışı doğrulama
        // Dönen liste boş olmamalı ve 2 eleman içermeli
        assert result != null;
        assert result.size() == 2;
        // İlk elemanın adı "Turkish Airlines" olmalı
        assert result.get(0).getName().equals("Turkish Airlines");
    }
}
