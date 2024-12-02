package test;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {
  @Mock
  private AddressRepository addressRepository;

  @InjectMocks
  private AddressService addressService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testSaveAddress() {
    Address address = new Address(1, "John", "Doe", "12345", new Date());
    when(addressRepository.save(address)).thenReturn(address);

    Address result = addressService.save(address);

    assertNotNull(result);
    assertEquals("John", result.getFirstname());
    verify(addressRepository, times(1)).save(address);
  }

  @Test
  void testGetAllAddresses() {
    Address a1 = new Address(1, "John", "Doe", "12345", new Date());
    Address a2 = new Address(2, "Jane", "Smith", "67890", new Date());

    when(addressRepository.findAll()).thenReturn(Arrays.asList(a1, a2));

    var addresses = addressService.getAll();

    assertEquals(2, addresses.size());
    verify(addressRepository, times(1)).findAll();
  }

  @Test
  void testGetAddressById() {
    Address address = new Address(1, "John", "Doe", "12345", new Date());
    when(addressRepository.findById(1)).thenReturn(Optional.of(address));

    Optional<Address> result = addressService.getAddress(1);

    assertTrue(result.isPresent());
    assertEquals("John", result.get().getFirstname());
    verify(addressRepository, times(1)).findById(1);
  }
}
