describe('Student Management', () => {
  it('should load the students', () => {
      cy.visit('http://localhost:5500');
      cy.get('table tbody tr').should('exist');
  });

  it('should load students correct', () => {
    cy.visit('http://localhost:5500');
    cy.get('table tbody tr').should('exist');
    cy.get('table tbody tr').first().within(() => {
      cy.contains("Jonas")
    });
  });

  it('should add a new student', () => {
      const name = 'Niel Müller';
      const email = 'niel@gmail.com';

      cy.visit('http://localhost:5500');
      cy.get('#name').type(name);
      cy.get('#email').type(email);
      cy.get('form').submit();

      cy.get('table tbody tr').last().within(() => {
          cy.contains(name);
          cy.contains(email);
      });
  });
});
