package dev.feryadi.springboothexagonalarchitecture.internal.validator;

import br.com.fluentvalidator.AbstractValidator;
import dev.feryadi.springboothexagonalarchitecture.internal.adapter.http.model.account.CreateAccountRequest;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Predicate.not;

@Component
public class CreateAccountRequestValidator extends AbstractValidator<CreateAccountRequest> {
    @Override
    public void rules() {
        ruleFor(CreateAccountRequest::name)
                .must(not(stringEmptyOrNull()))
                .withMessage("must not empty or null")
                .withFieldName("name");
    }
}
