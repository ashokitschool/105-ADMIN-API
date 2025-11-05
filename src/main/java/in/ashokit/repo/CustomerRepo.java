package in.ashokit.repo;

import in.ashokit.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

    public CustomerEntity findByEmailAndPassword(String email, String pwd);

    public CustomerEntity findByEmail(String email);

}
