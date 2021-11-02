package devops_project.presentation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import devops_project.application.user.UserService;
import devops_project.domain.user.UserEntity;
import devops_project.infrastructure.entitycrud.EntityListController;

@Named
@RequestScoped
public class UserListController extends EntityListController<UserEntity, String, UserService> {

    @Inject
    UserService service;

    @Override
    protected UserService getService() {
        return service;
    }
}
