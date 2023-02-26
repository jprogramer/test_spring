package springsandbox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsandbox.Entity.MutableUser;

public interface MutableUserRepo extends JpaRepository<MutableUser, Long> {

}
