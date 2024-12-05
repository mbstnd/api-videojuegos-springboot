package ipss.cl.apis70.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ipss.cl.apis70.models.Videojuego;

public interface VideojuegoRepository extends MongoRepository<Videojuego, String> {

}
