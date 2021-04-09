package io.github.pgerhard.views.popup;


import com.vaadin.componentfactory.Popup;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route ( value = "popup" )
public class PopupRoute  extends Composite<Div> {

    /**
     * Constructor.
     */
    public PopupRoute () {
        setId ( "dashboard-route" );
        this.getContent ().add ( createPopupDemo () );
    }

    private Component createPopupDemo () {
        Button button = new Button ( "Push Me" );
        button.setId ( "push-me" );

        Popup popup = new Popup ();
        popup.setFor ( button.getId ().orElse ( null ) );
        Div text = new Div ();
        text.setText ( "element 1" );
        Div text2 = new Div ();
        text2.setText ( "element 2" );
        popup.add ( text, text2 );

        Div closeOnClickStatus = new Div ();
        closeOnClickStatus.setText ( "Close on click: " + popup.isCloseOnClick () );

        Div eventStatus = new Div ();
        popup.addPopupOpenChangedEventListener ( event -> {
            if ( event.isOpened () ) {
                eventStatus.setText ( "Popup opened" );
            }
            else {
                eventStatus.setText ( "Popup closed" );
            }
        } );

        return new Div ( button, popup, closeOnClickStatus, eventStatus );
    }

}
