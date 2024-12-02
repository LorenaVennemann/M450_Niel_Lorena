package test;

import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddressControllerTestWithoutSpring {

  @Mock
  private AddressService addressService;

  @InjectMocks
  private AddressController addressController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreateAddress() {
    Address address = new Address(1, "John", "Doe", "123456789", new Date());
    when(addressService.save(any(Address.class))).thenReturn(address);

    ResponseEntity<Address> response = addressController.createAddress(address);

    System.out.println("Mock Address: " + address);
    System.out.println("Response Body: " + response.getBody());

    verify(addressService).save(any(Address.class));
    assertEquals(201, response.getStatusCodeValue());
    assertEquals(address, response.getBody());
  }

  @Test
  public void testGetAddresses() {
    List<Address> addresses = Arrays.asList(
        new Address(1, "John", "Doe", "123456789", new Date()),
        new Address(2, "Jane", "Smith", "987654321", new Date())
    );

    when(addressService.getAll()).thenReturn(addresses);

    ResponseEntity<List<Address>> response = addressController.getAddresses();

    System.out.println("Mock Addresses Response: " + response);
    System.out.println("Mock Addresses List: " + addresses);
    System.out.println("Response Body: " + response.getBody());

    verify(addressService).getAll();
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(addresses, response.getBody());
  }

  @Test
  public void testGetAddress() {
    Address address = new Address(1, "John", "Doe", "123456789", new Date());
    when(addressService.getAddress(1)).thenReturn(Optional.of(address));

    ResponseEntity<Address> response = addressController.getAddress(1);

    System.out.println("Mock Address: " + address);
    System.out.println("Response Body: " + response.getBody());

    verify(addressService).getAddress(1);
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(address, response.getBody());
  }

  @Test
  public void testGetAddressNotFound() {
    when(addressService.getAddress(1)).thenReturn(Optional.empty());

    ResponseEntity<Address> response = addressController.getAddress(1);

    System.out.println("Response Body: " + response.getBody());

    verify(addressService).getAddress(1);
    assertEquals(404, response.getStatusCodeValue());
  }
}

