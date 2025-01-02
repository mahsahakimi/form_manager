package edu.sharif.web.repository;

import edu.sharif.web.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface FormRepository extends JpaRepository<Form, Long> {
//    Optional<Form> findByEmail(String email);
    Optional<Form> findByName(String name);

    @Query(value = "SELECT f FROM Form f WHERE f.published = true")
    List<Form> findByPublishedTrue();

//    @Query(value = "SELECT c FROM Customer c WHERE c.name = ?1 AND c.email = ?2")
//    List<Form> findAllByNameAndEmail(String name, String email);
}
