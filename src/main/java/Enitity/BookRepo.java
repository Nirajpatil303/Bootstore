package Enitity;

import org.springframework.data.repository.CrudRepository;


public interface BookRepo extends CrudRepository<Book, Long> {
    // You can define custom query methods here if needed
}
