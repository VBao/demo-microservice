package vn.itlearn.account.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.itlearn.account.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
