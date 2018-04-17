package by.gorodkevich.app.repository;


import by.gorodkevich.app.models.SolrEntity;
import org.springframework.data.solr.repository.SolrCrudRepository;


public interface EmailRepository extends CustomizedEmailLetterRepository, SolrCrudRepository<SolrEntity, String> {



}
