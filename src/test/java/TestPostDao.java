import com.quancm.blog.daos.PostDao;
import com.quancm.blog.models.Post;
import org.junit.jupiter.api.Test;

public class TestPostDao {
    private PostDao postDao = new PostDao();

    @Test
    public void testAddPost(){
        Post post = new Post();
        post.setTitle("Test title");
        post.setDescription("Test description");
        post.setContent("Test content");
        post.setAuthor("quancm0406");
        post.setImageUrl("/images/character-banner-first.jpg");
        postDao.addPost(post);
    }



}
