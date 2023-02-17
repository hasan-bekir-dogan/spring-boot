package com.bekirdogan;

import com.bekirdogan.data.entity.EmployeeEntity;
import com.bekirdogan.data.repository.EmployeeRepository;
import com.bekirdogan.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatikaSpringBootApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    // Create
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Bekir Test")
                .LastName("Doğan Test")
                .emailId("bekirtest@hotmail.com")
                .build();

        employeeRepository.save(employeeEntity);

        // nesne null ise assertionError hatası göndersin
        assertNotNull(employeeRepository.findById(5L).get());
    }

    // List
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();

        // eğer sıfırdan büyükse liste vardır
        assertThat(list).size().isGreaterThan(0);
    }

    // FindById
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(5L).get();

        // Bekir Test adında kayıt var mı yok mu
        assertEquals("Bekir Test", employeeEntity.getFirstName());
    }

    // Update
    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(5L).get();
        employeeEntity.setFirstName("Bekir 66 Test");
        employeeRepository.save(employeeEntity);

        // eşit değilse bir sorun olmayacak ama eşitse exception fırlatsın
        assertNotEquals("Bekir Test", employeeRepository.findById(5L).get().getFirstName());
    }

    // Delete
    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(5L);

        // isFalse
        assertThat(employeeRepository.existsById(5L)).isFalse();
    }
}
