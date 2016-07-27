package groovy

import org.apache.solr.client.solrj.beans.Field;
import java.util.Date

/**
 * Url Info
 *
 */
class UrlInfo {
    @Field("url")
    String url

    @Field("metaKeywords")
    String metaKeywords

    @Field("last_update")
    Date last_update
}
