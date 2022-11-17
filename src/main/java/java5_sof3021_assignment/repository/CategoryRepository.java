package java5_sof3021_assignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java5_sof3021_assignment.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	Page<Category> findByNameLike(String name, Pageable pageable);
//	List<Category> findByIdEquals(Integer Id);
}
