package app.iwaiter.services;

import app.iwaiter.dto.GarcomDto;
import app.iwaiter.entities.Garcom;
import app.iwaiter.repositories.GarcomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarcomService {

    @Autowired
    private GarcomRepository garcomRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public GarcomDto criarGarcom(final GarcomDto input) {
        return getGarcomDto(input);
    }

    private GarcomDto getGarcomDto(final GarcomDto input) {
        boolean usuarioJaCadastrado = garcomRepository.findByUsuario(input.getUsuario()).isPresent();
        if (usuarioJaCadastrado)
            throw new IllegalArgumentException("Nome de usuário indisponível. Informe outro usuário.");

        garcomRepository.save(new Garcom(
                input.getId(),
                input.getNome(),
                input.getFotoPerfil(),
                input.getUsuario(),
                passwordEncoder.encode(input.getSenha()),
                input.getCpf()));

        return input;
    }

    public List<GarcomDto> listaGarcons() {
        return garcomRepository.findAll().stream().map(
                cada -> new GarcomDto(
                        cada.getId(),
                        cada.getNome(),
                        cada.getFotoPerfil(),
                        cada.getUsuario(),
                        cada.getSenha(),
                        cada.getCpf()
                )
        ).collect(Collectors.toList());
    }

    @Transactional
    public void excluirGarcom(Long id) {
        if (!garcomRepository.existsById(id))
            throw new IllegalArgumentException("Garçom não encontrado.");
        garcomRepository.deleteById(id);
    }
}
