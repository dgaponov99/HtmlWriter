import HTML.*;

import java.util.Arrays;

public class HtmlTest {
    public static void main(String[] args) {
        Body body = new Body(Arrays.asList(
                new Tag("tag1",
                        new Tag("tag_in_1",
                                new Text("Hello")
                        )
                ),
                new Tag("tag2", Arrays.asList(
                        new Tag("tag_in_2",
                                new Tag("tag_20",
                                        new Text("Hello2")
                                )
                        ),
                        new Tag("tag_21", Arrays.asList(
                                new Text("Hello3"),
                                new Text("Hello4")
                        ))
                ))
        ));
        body.flush("test.txt");
        body.clearBody();
        body.flush("test1.txt");
        body.addToBody(new Text("Hello World"));
        body.addToBody(new Tag("tag_in_1", new Text("Hello")));
        body.flush("text2.txt");
        body.addToBody(Arrays.asList(new Text("ggg"), new Tag("tagP", new Text("fff"))));
        body.addTo("tagp", new Text("fff2"));
        body.flush("test3.txt");
    }
}
