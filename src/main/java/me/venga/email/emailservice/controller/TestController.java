package me.venga.email.emailservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Test Controller", description = "Endpoints para teste de integridade da API")
public class TestController {

    @Operation(summary = "Verificar Status da API (GET)", description = "Verifica se a API está funcionando corretamente com uma requisição GET.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API operacional"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @CrossOrigin
    @GetMapping("/getstatusapp")
    public String getStatusApp() {
        return "{\"status\":\"up\"}";
    }

    @Operation(summary = "Verificar Status da API (POST)", description = "Verifica se a API está funcionando corretamente com uma requisição POST.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API operacional"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @CrossOrigin
    @PostMapping("/poststatusapp")
    public String postStatusApp() {
        return "{\"status\":\"up\"}";
    }
}
