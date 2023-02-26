package springsandbox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsandbox.Entity.ImmutableUser;

public interface ImmutableUserRepo extends JpaRepository<ImmutableUser, Long> {

}
