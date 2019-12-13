package com.juleq.ciphertranslator.ui;

import com.juleq.ciphertranslator.backend.model.ConversionType;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorFactory;
import com.juleq.ciphertranslator.backend.service.CipherTranslatorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PageTitle("Cipher translator")
@PreserveOnRefresh
public class MainView extends VerticalLayout {

    @Autowired
    private CipherTranslatorFactory factory;

    public MainView() {
        H1 heading = new H1("Cipher translator");

        TextArea sourceArea = new TextArea();
        sourceArea.setMinWidth("600px");
        sourceArea.setMinHeight("200px");

        TextArea destinationArea = new TextArea();
        destinationArea.setMinWidth("600px");
        destinationArea.setMinHeight("200px");

        ComboBox<ConversionType> typeMenu = new ComboBox<>();
        typeMenu.setMinWidth("365px");
        typeMenu.setPlaceholder("Select conversion type");
        typeMenu.setItems(ConversionType.values());
        typeMenu.setValue(ConversionType.TEXT_MORSE);

        TextField wordSeparator = new TextField();
        wordSeparator.setMaxWidth("100px");
        wordSeparator.setMaxLength(1);
        wordSeparator.setValue("|");
        wordSeparator.setPlaceholder("Separator");

        Label errorOutput = new Label();
        errorOutput.getStyle().set("color", "red");

        Button button = new Button("Submit");
        button.setMinWidth("100px");
        button.setEnabled(false);

        HorizontalLayout controlLayout = new HorizontalLayout();
        controlLayout.setMaxWidth("600px");
        controlLayout.add(typeMenu, wordSeparator, button);

        registerListeners(sourceArea, destinationArea, typeMenu, wordSeparator, errorOutput, button);
        add(heading, sourceArea, controlLayout, destinationArea, errorOutput);
    }

    private String translate(ConversionType type, String text, String wordSeparator, Label errorOutput) {
        try {
            CipherTranslatorService service = factory.getService(type);
            return service.translate(text, wordSeparator.charAt(0));
        } catch (IllegalArgumentException e) {
            errorOutput.setText("Error occurred: " + e.getMessage());
            return "";
        }
    }

    private void registerListeners(TextArea sourceArea, TextArea destinationArea, ComboBox<ConversionType> typeMenu, TextField wordSeparator, Label errorOutput, Button button) {
        button.addClickListener(event -> {
            String translation = translate(typeMenu.getValue(), sourceArea.getValue(), wordSeparator.getValue(), errorOutput);
            destinationArea.setValue(translation);
        });
        wordSeparator.addBlurListener(event -> button.setEnabled(!wordSeparator.getValue().isBlank()));
        sourceArea.addBlurListener(event -> button.setEnabled(!sourceArea.getValue().isBlank()));
    }
}
