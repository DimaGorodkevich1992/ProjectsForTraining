package by.gorodkevich.app.repository;

import by.gorodkevich.app.models.SolrEntity;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.*;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Component
public class EmailRepositoryImpl implements CustomizedEmailLetterRepository {

    private SolrOperations solrTemplate;

    public EmailRepositoryImpl(SolrOperations solrTemplate) {
        this.solrTemplate = solrTemplate;
    }

    @Override
    public void submit(Collection<SolrEntity> entityCollection) {
        Collection<PartialUpdate> collectionToUpdates = new ArrayList<>();


        for (SolrEntity solrEntity : entityCollection) {
            SolrInputDocument solrInputDocument = solrTemplate.convertBeanToSolrInputDocument(solrEntity);

            for (SolrInputField field : solrInputDocument) {
                if (field.getValue() instanceof java.time.LocalDateTime) {
                    LocalDateTime tmp = (LocalDateTime) field.getValue();
                    Date convertDateTime = Date.from(tmp.atZone(ZoneId.systemDefault()).toInstant());
                    field.setValue(convertDateTime, field.getBoost());
                    break;
                }
            }

            PartialUpdate partialUpdate = null;
            for (Map.Entry<String, SolrInputField> entry : solrInputDocument.entrySet()) {
                if (entry.getKey().equals("id")) {
                    partialUpdate = new PartialUpdate(entry.getKey(), entry.getValue());
                    break;
                }
            }

            for (Map.Entry<String, SolrInputField> entry : solrInputDocument.entrySet()) {
                if (!entry.getKey().equals("id")) {
                    partialUpdate.setValueOfField(entry.getKey(), entry.getValue());
                }
            }

            collectionToUpdates.add(partialUpdate);
            solrTemplate.saveBeans("EmailLetter", collectionToUpdates);
        }

    }

}
