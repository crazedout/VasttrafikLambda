package andreas.aws.vasttrafik.model.qna;

public class QNABotResponseSessionNavigation
{
    /*
    "navigation":
    {
        "next": "",
        "previous": [],
        "hasParent": false
    }
    */

    String next;
    QNABotResponseSessionNavigationPrevious[] previous;
    boolean hasParent;
}
