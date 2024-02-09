package dev.feryadi.springboothexagonalarchitecture.internal.adapter.usecase;

import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UseCase;
import dev.feryadi.springboothexagonalarchitecture.internal.port.usecase.UseCases;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUseCase implements UseCase {

    private UseCases useCases;

    @Autowired
    public void setUseCases(UseCases useCases) {
        this.useCases = useCases;
    }

    @Override
    public UseCases getUseCases() {
        return useCases;
    }
}
