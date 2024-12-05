package ipss.cl.apis70.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipss.cl.apis70.models.Videojuego;
import ipss.cl.apis70.repositories.VideojuegoRepository;

@Service
public class VideojuegoService {
  @Autowired
  public VideojuegoRepository videojuegoRepository;

  // Crear

  public Videojuego crear(Videojuego videojuego) {
    return videojuegoRepository.save(videojuego);
  }

}
