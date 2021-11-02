package devops_project.application.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import devops_project.domain.user.UserEntity;
import devops_project.domain.user.UserRepository;
import devops_project.infrastructure.data.jpa.BaseRepository;
import devops_project.infrastructure.entitycrud.BaseService;

/**
 * このクラスは、ユーザーマスターのサービスです。
 * 
 * @author SIToolkit
 **/
@ApplicationScoped
@Transactional
public class UserService extends BaseService<UserEntity, String> {

    @Inject
    UserRepository dao;

    @Override
    public BaseRepository<UserEntity, String> getDao() {
        return dao;
    }

}
