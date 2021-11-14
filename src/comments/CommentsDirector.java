package comments;

public class CommentsDirector {

  public CommentsDirector() {}

  public Comments builderComments(String content) {
    Comments comments = new Comments();
    comments.setId();
    comments.setContent(content);
    comments.setTemporaryCode();
    return comments;
  }

  public Comments builderReply(String content, Comments origin) {
    Comments comments = new Comments();
    comments.setId();
    comments.setContent(content);
    comments.setTemporaryCode();
    comments.setReply(true);
    comments.setOriginComment(origin);
    return comments;
  }
}
