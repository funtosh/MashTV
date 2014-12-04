package me.taborda.mashtv.controller ;

import java.util.List ;

import javax.validation.constraints.NotNull ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.bind.annotation.RestController ;

import me.taborda.mashtv.model.Feed ;
import me.taborda.mashtv.service.FeedService ;

@RestController
@RequestMapping("/api/feeds")
public class RestFeedController {

    private static final Logger LOG = LoggerFactory.getLogger(RestFeedController.class) ;

    @Autowired
    private FeedService feeds ;

    @RequestMapping(value = "")
    public List<Feed> list() {
        return feeds.getAll() ;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@NotNull @RequestParam final String url) {
        Feed feed = feeds.add(url.trim()) ;
        LOG.info("Added feed: {}", feed) ;
        feeds.load(feed) ;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable final long id) {
        Feed f = feeds.get(id) ;
        feeds.delete(f) ;
        LOG.info("Removed feed: {}", f) ;
    }

    @RequestMapping(value = "/{id}/load", method = RequestMethod.POST)
    public void load(@PathVariable final long id) {
        Feed f = feeds.get(id) ;
        feeds.load(f) ;
    }

}