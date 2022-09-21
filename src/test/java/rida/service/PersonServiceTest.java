package rida.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rida.data.Person;
import rida.repository.PersonRepository;

@Extensions(
        @ExtendWith(MockitoExtension.class)
)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;


    @BeforeEach
    void setUp()
    {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound()
    {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess()
    {
        //menambah behaviour ke mock object
        Mockito.when(personRepository.selectById("rida"))
                .thenReturn(new Person("1", "rida adila"));
        var person = personService.get("rida");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("rida adila", person.getName());
    }

    @Test
    void testRegisterSuccess()
    {
        var person = personService.register("rida adila register");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("rida adila register", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), person.getName()));
    }
}
