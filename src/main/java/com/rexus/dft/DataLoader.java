package com.rexus.dft;

import com.rexus.dft.categoriaservico.CategoriaServicoService;
import com.rexus.dft.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.enums.TipoMetodologiaEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    private final CategoriaServicoService categoriaServicoService;

    public DataLoader(CategoriaServicoService categoriaServicoService) {
        this.categoriaServicoService = categoriaServicoService;
    }

    @Override
    public void run(String... args) {
        log.info("Carregando dados de teste...");
        for (int i = 1; i <= 10; i++) {
            categoriaServicoService.salvar(new CategoriaServicoDto("Categoria Típica " + i, TipoMetodologiaEnum.TIPICA));
            categoriaServicoService.salvar(new CategoriaServicoDto("Categoria Aípica " + i, TipoMetodologiaEnum.ATIPICA));
            categoriaServicoService.salvar(new CategoriaServicoDto("Categoria Outra " + i, TipoMetodologiaEnum.OUTRA));
        }
        log.info("Carga de dados concluída");
    }
}