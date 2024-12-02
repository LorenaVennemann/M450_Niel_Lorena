package test;

import ch.tbz.m450.AddressbookApplication;
import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AddressbookApplication.class)
public class AddressControllerTest {

  // @Autowired
  // private AddressService addressService;

  @Autowired
  private AddressController addressController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testCreateAddress() {
    Address address = new Address(1, "John", "Doe", "123456789", new Date());
    // when(addressService.save(any(Address.class))).thenReturn(address);

    ResponseEntity<Address> response = addressController.createAddress(address);

    System.out.println("Mock Address: " + address);
    System.out.println("Response Body: " + response.getBody());

    assertEquals(201, response.getStatusCodeValue());
    assertEquals(address, response.getBody());
  }

    @Test
    public void testGetAddresses() {
      List<Address> addresses = Arrays.asList(
          new Address(1, "John", "Doe", "123456789", new Date()),
          new Address(2, "Jane", "Smith", "987654321", new Date())
      );

      // when(addressService.getAll()).thenReturn(addresses);

      ResponseEntity<List<Address>> response = addressController.getAddresses();

      // Debugging-Output
      System.out.println("Mock Addresses: " + response);
      System.out.println("Mock Addresses: " + addresses);
      System.out.println("Response Body: " + response.getBody());

      // Verify that the getAll method was called on the mock
      //verify(addressService).getAll();

      // assertEquals(200, response.getStatusCodeValue());
      assertEquals(addresses, response.getBody());
    }
//
//  @Test
//  public void testGetAddress() {
//    Address address = new Address(1, "John", "Doe", "123456789", new Date());
//    when(addressService.getAddress(1)).thenReturn(Optional.of(address));
//
//    ResponseEntity<Address> response = addressController.getAddress(1);
//
//    System.out.println("Mock Address: " + address);
//    System.out.println("Response Body: " + response.getBody());
//
//    assertEquals(200, response.getStatusCodeValue());
//    assertEquals(address, response.getBody());
//  }
//
//  @Test
//  public void testGetAddressNotFound() {
//    when(addressService.getAddress(1)).thenReturn(Optional.empty());
//
//    ResponseEntity<Address> response = addressController.getAddress(1);
//
//    System.out.println("Response Body: " + response.getBody());
//    assertEquals(404, response.getStatusCodeValue());
//  }
}
