package ch.tbz.m450.repository;

import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AddressRepositoryTest {

  @Autowired
  private AddressRepository addressRepository;

  private Address testAddress;

  @BeforeEach
  void setUp() {
    // Initialisiere ein Testobjekt
    testAddress = new Address(1, "John", "Doe", "1234567890", new Date());
  }

  @Test
  void saveAddress_shouldPersistData() {
    // Adresse speichern
    Address savedAddress = addressRepository.save(testAddress);

    // Überprüfen, ob sie korrekt gespeichert wurde
    assertThat(savedAddress).isNotNull();
    assertThat(savedAddress.getId()).isEqualTo(testAddress.getId());
    assertThat(savedAddress.getFirstname()).isEqualTo(testAddress.getFirstname());
  }

  @Test
  void findById_shouldReturnAddress() {
    // Adresse speichern und finden
    addressRepository.save(testAddress);
    Optional<Address> foundAddress = addressRepository.findById(1);

    // Überprüfen, ob die richtige Adresse zurückgegeben wurde
    assertThat(foundAddress).isPresent();
    assertThat(foundAddress.get().getLastname()).isEqualTo("Doe");
  }

  @Test
  void deleteAddress_shouldRemoveData() {
    // Adresse speichern und löschen
    addressRepository.save(testAddress);
    addressRepository.deleteById(1);

    // Überprüfen, ob die Adresse gelöscht wurde
    Optional<Address> deletedAddress = addressRepository.findById(1);
    assertThat(deletedAddress).isEmpty();
  }
}
