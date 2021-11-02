package devops_project.domain.user;

import java.util.List;

import javax.persistence.Query;

import devops_project.infrastructure.data.jpa.BaseRepository;
import devops_project.infrastructure.layer.Repository;

/**
 * このクラスは、ユーザーマスターのDAOです。
 *
 * @author SIToolkit
 */
@Repository
public class UserRepository extends BaseRepository<UserEntity, String> {

    private static final long serialVersionUID = 2225666869914977661L;

    @Override
    public Class<UserEntity> getEntityType() {
        return UserEntity.class;
    }

    /**
     * ユーザー姓をキーにUserEntityを抽出します。
     *
     * @param lastName
     *            ユーザー姓
     * @return UserEntity
     */
    @SuppressWarnings("unchecked")
    public List<UserEntity> selectByLastName(String lastName) {
        Query query = em()
                .createQuery("SELECT user FROM UserEntity user WHERE user.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
