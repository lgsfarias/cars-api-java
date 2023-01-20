package com.carsapi.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarsDTO(

    @NotBlank(message = "O campo modelo é obrigatório") String modelo,

    @NotBlank(message = "O campo fabricante é obrigatório") String fabricante,

    @NotBlank(message = "O campo data de fabricação é obrigatório") @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", message = "O campo data de fabricação deve estar no formato dd/MM/yyyy") String dataFabricacao,

    @NotNull(message = "O campo valor é obrigatório") Double valor,

    @NotNull(message = "O campo ano do modelo é obrigatório") Integer anoModelo) {

}
