package sap.crun.performance.api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sap.crun.performance.api.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
