package kg.alatoo.ticketsellingapp.repositories;

import kg.alatoo.ticketsellingapp.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DistributorRepository extends CrudRepository<Distributor,Long>,
        JpaRepository<Distributor, Long>
{
}
