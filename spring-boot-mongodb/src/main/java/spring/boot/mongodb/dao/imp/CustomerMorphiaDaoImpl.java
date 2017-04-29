package spring.boot.mongodb.dao.imp;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.boot.mongodb.dao.ICustomerMorphiaDao;
import spring.boot.mongodb.entity.CustomerMorphia;

@Repository
public class CustomerMorphiaDaoImpl implements ICustomerMorphiaDao {

	@Autowired
	private Datastore datastore;
	
	public Key<CustomerMorphia> save(CustomerMorphia customerMorphia) {
		return datastore.save(customerMorphia);
	}

	public UpdateResults update(CustomerMorphia customerMorphia) {
		Query<CustomerMorphia> query = datastore.createQuery(CustomerMorphia.class).field("id").equal(customerMorphia.getId());
		UpdateOperations<CustomerMorphia> operations =  datastore.createUpdateOperations(CustomerMorphia.class).set("firstname", customerMorphia.getFirstname()).set("secondname", customerMorphia.getSecondname());
		return this.datastore.update(query, operations);
//		return datastore.update(customerMorphia, datastore.createUpdateOperations(CustomerMorphia.class));
	}

	public CustomerMorphia findById(String objid) {
		return datastore.getByKey(CustomerMorphia.class, new Key<CustomerMorphia>(CustomerMorphia.class, "CustomerMorphia", new ObjectId(objid)));
	}

	public void delete(String objid) {
		datastore.delete(datastore.createQuery(CustomerMorphia.class).field("id").equal(new ObjectId(objid)));
	}

}
