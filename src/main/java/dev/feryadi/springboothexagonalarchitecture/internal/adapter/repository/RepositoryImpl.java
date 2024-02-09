package dev.feryadi.springboothexagonalarchitecture.internal.adapter.repository;

import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.Repositories;
import dev.feryadi.springboothexagonalarchitecture.internal.port.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryImpl implements Repository {

    private Repositories repositories;

    @Override
    public Repositories getRepositories() {
        return repositories;
    }

    @Autowired
    public void setRepositories(Repositories repositories) {
        this.repositories = repositories;
    }
}
