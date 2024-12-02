package test;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressComparatorTest {

  @Test
  void testCompareDifferentLastNames() {
    Address a1 = new Address(1, "John", "Doe", "12345", new Date());
    Address a2 = new Address(2, "Jane", "Smith", "67890", new Date());

    AddressComparator comparator = new AddressComparator();
    assertTrue(comparator.compare(a1, a2) < 0); // Doe < Smith
  }

  @Test
  void testCompareSameLastNameDifferentFirstNames() {
    Address a1 = new Address(1, "John", "Doe", "12345", new Date());
    Address a2 = new Address(2, "Jane", "Doe", "67890", new Date());

    AddressComparator comparator = new AddressComparator();
    assertTrue(comparator.compare(a1, a2) > 0); // John > Jane
  }

  @Test
  void testCompareSameLastAndFirstNamesDifferentRegistrationDates() {
    Address a1 = new Address(1, "John", "Doe", "12345", new Date(1000));
    Address a2 = new Address(2, "John", "Doe", "67890", new Date(2000));

    AddressComparator comparator = new AddressComparator();
    assertTrue(comparator.compare(a1, a2) < 0); // Older date first
  }
}
