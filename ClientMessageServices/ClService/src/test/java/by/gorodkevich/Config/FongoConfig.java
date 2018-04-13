package by.gorodkevich.Config;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration//todo profile
@Profile("fongoConfig")
@EnableMongoRepositories(basePackages = "by.gorodkevich.mongoRepository")
public class FongoConfig extends AbstractMongoConfiguration  {
    @Override
    protected String getDatabaseName() {
        return "demo-test";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(getDatabaseName()).getMongo();
    }


}
