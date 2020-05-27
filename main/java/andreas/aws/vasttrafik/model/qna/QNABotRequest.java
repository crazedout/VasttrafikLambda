package andreas.aws.vasttrafik.model.qna;

public class QNABotRequest
{
    QNABotRequestEvent _event;
    QNABotRequestSettings _settings;
    String _type;
    String _userId;
    String question;
    QNABotRequestSession session;
    QNABotRequestUserInfo _userInfo;
    QNABotRequestInfo _info;
}
