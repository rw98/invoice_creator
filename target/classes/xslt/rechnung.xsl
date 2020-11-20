<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
>
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                        master-name="A4"
                        page-height="29.7cm"
                        page-width="21.0cm"
                        margin="1cm">
                    <fo:region-body/>
                    <fo:region-before extent="20mm" region-name="kopf" display-align="center"/>
                    <fo:region-after extent="40mm" region-name="Inhalt-rechts-davor" display-align="center"/>
                    <fo:region-start extent="40mm" region-name="links"/>
                    <fo:region-end extent="40mm" region-name="rechts"/>

                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:static-content flow-name="Inhalt-rechts-davor">
                    <fo:table font-size="10pt" width="120mm" background-color="#FFFFFF" color="#000000"
                              padding="1em 0 1em 0 ">
                        <fo:table-column column-number="1" column-width="40mm"/>
                        <fo:table-column column-number="2" column-width="40mm"/>
                        <fo:table-column column-number="3" column-width="40mm"/>
                        <fo:table-body>
                            <fo:table-cell column-number="1" display-align="before" margin="0 0 0 0.2em"
                                           padding="1em 0 1em 0 ">
                                <fo:block font-weight="bold">
                                    <xsl:text>Kunde:</xsl:text>
                                </fo:block>
                                <fo:block>
                                    <xsl:value-of select="rechnung/name"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell column-number="3" display-align="before" margin="0 0 0 0.2em "
                                           padding="1em 0 1em 0 " border-left="0.25mm solid #000000">
                                <fo:block text-align="left">
                                    <xsl:text>Richard Weser</xsl:text>
                                </fo:block>
                                <fo:block text-align="left">
                                    <xsl:text>Am Roßthaler Bach 22, 01159 Dresden</xsl:text>
                                </fo:block>
                                <fo:block text-align="left">
                                    <xsl:text>E-Mail: richard@weser-mail.de</xsl:text>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell column-number="2" display-align="before" margin="0 0 0 0.2em"
                                           padding="1em 0 1em 0 " border-left="0.25mm solid #000000">

                                <fo:block text-align="left">
                                    <xsl:text>Steuernummer: 203 / 286 / 28083 </xsl:text>
                                </fo:block>
                                <fo:block text-align="left">
                                    <xsl:text>IBAN: DE03 1001 1001 2629 6458 01</xsl:text>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-body>
                    </fo:table>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">+
                    <fo:block color="#000000" text-align="center" font-size="60pt" margin="1em 0 1em 0">
                        Rechnung
                    </fo:block>
                    <fo:block-container text-align="left" margin="0 0 0 1em">
                        <fo:block>
                            Rechnungsnummer: <xsl:value-of select="rechnung/bestellnummer"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="rechnung/name"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="rechnung/strasse"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="rechnung/strasse2"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="rechnung/plz"/>&#160;<xsl:value-of select="rechnung/stadt"/>
                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="rechnung/land"/>
                        </fo:block>
                    </fo:block-container>
                    <fo:block-container margin="1em 0 0 3em">
                        <fo:block font-size="32pt" font-weight="bold" text-align="center">
                            <fo:table font-size="10pt" width="120mm" color="#000000"
                                      padding="1em 0 1em 0 ">
                                <fo:table-column column-number="1" column-width="50mm"/>
                                <fo:table-column column-number="2" column-width="30mm"/>
                                <fo:table-column column-number="3" column-width="30mm"/>
                                <fo:table-column column-number="4" column-width="30mm"/>
                                <fo:table-body>
                                    <fo:table-row>
                                        <fo:table-cell column-number="1" margin="0 0 0 0.2em" font-weight="bold">
                                            <fo:block>
                                                <xsl:text>Bezeichnung</xsl:text>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="2" margin="0 0 0 0.2em" font-weight="bold">
                                            <fo:block>
                                                Anzahl
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="3" margin="0 0 0 0.2em" font-weight="bold">
                                            <fo:block>
                                                Preis
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="4" margin="0 0 0 0.2em" font-weight="bold">
                                            <fo:block>
                                                Gesamt
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell column-number="1" margin="0 0 0 0.2em" font-weight="300">
                                            <fo:block>
                                                <xsl:value-of select="rechnung/artikelName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="2" margin="0 0 0 0.2em" font-weight="300">
                                            <fo:block>
                                                <xsl:value-of select="rechnung/menge"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="3" margin="0 0 0 0.2em" font-weight="300">
                                            <fo:block>
                                                <xsl:value-of select="rechnung/artikelPreis"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell column-number="4" margin="0 0 0 0.2em" font-weight="300">
                                            <fo:block>
                                                <xsl:value-of select="rechnung/artikelPreis"/>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                        <fo:block text-align="right">
                            <fo:block margin="1em 0 0 1em">
                                <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid"
                                           rule-thickness="2pt"/>
                            </fo:block>
                            <fo:block margin="0.5em 0 0 0">
                                Versandkosten: <xsl:value-of select="rechnung/versandkosten"/>  €
                            </fo:block>
                            <fo:block margin="0.5em 0 0 0">
                                Rabatt Versandkosten: <xsl:value-of select="rechnung/rabattVersandkosten"/>  €
                            </fo:block>
                            <fo:block margin="0.5em 0 0 0">
                                Versandkosten Gesamt: <xsl:value-of select="rechnung/versandInsgesamt"/>  €
                            </fo:block>

                            <fo:block font-weight="bold" margin="0.5em 0 0 0">
                                Gesamt: <xsl:value-of select="rechnung/artikelPreis"/> €
                            </fo:block>
                        </fo:block>
                        <fo:block text-align="left">
                            Datum: <xsl:value-of select="rechnung/bestelldatum"/>
                        </fo:block>
                        <fo:block text-align="center" margin="0.5em 0em 0em 0em">
                            Sofern kein anderes Datum angegeben, entspricht das Liefer/Leistungsdatum dem Rechnungsdatum.
                            Kein Ausweis von Umsatzsteuer, da Kleinunternehmer gemäß § 19 UStG
                        </fo:block>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>


</xsl:stylesheet>

