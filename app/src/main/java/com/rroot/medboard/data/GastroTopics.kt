package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object GastroTopics {

    private val cirrhosis = Topic(
        id = "gi-cirrhosis",
        title = "Cirrhosis and its Complications",
        subtitle = "Portal hypertension, ascites, SBP, HE, HRS",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 342 \u2014 Cirrhosis and its complications"),
            TopicReference("Davidson 24e", "Ch. 22 \u2014 Hepatology (Cirrhosis and its complications)"),
        ),
        sections = listOf(
            TopicSection(
                "Aetiology & diagnosis",
                listOf(
                    Paragraph(
                        "Cirrhosis is the final common pathway of chronic liver injury: diffuse fibrosis with nodular regeneration, architectural distortion and functional failure. Leading causes worldwide are chronic viral hepatitis (HBV, HCV), alcohol-related liver disease, and metabolic dysfunction-associated steatotic liver disease (MASLD). Other causes include autoimmune hepatitis, primary biliary cholangitis, primary sclerosing cholangitis, haemochromatosis, Wilson disease, and \u03b11-antitrypsin deficiency."
                    ),
                    Bullets(
                        listOf(
                            "Non-invasive fibrosis assessment: transient elastography (FibroScan), ELF score, FIB-4.",
                            "Biopsy when non-invasive tests are equivocal or aetiology unclear.",
                            "Child-Pugh (5\u201315) and MELD-Na scores estimate prognosis and transplant priority.",
                        )
                    ),
                    Table(
                        title = "Child-Pugh scoring (1/2/3 points)",
                        headers = listOf("Parameter", "1", "2", "3"),
                        rows = listOf(
                            listOf("Bilirubin \u03bcmol/L", "< 34", "34\u201351", "> 51"),
                            listOf("Albumin g/L", "> 35", "28\u201335", "< 28"),
                            listOf("INR", "< 1.7", "1.7\u20132.2", "> 2.2"),
                            listOf("Ascites", "None", "Mild, diuretic responsive", "Refractory"),
                            listOf("Encephalopathy", "None", "Grade 1\u20132", "Grade 3\u20134"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Portal hypertension & varices",
                listOf(
                    Bullets(
                        listOf(
                            "Primary prophylaxis: non-selective beta-blocker (propranolol, nadolol) or carvedilol for clinically significant portal hypertension (HVPG \u2265 10 mmHg or presence of varices).",
                            "Endoscopic variceal band ligation if beta-blocker contraindicated or as alternative.",
                            "Acute bleed: terlipressin (or octreotide/somatostatin) + prophylactic antibiotic (ceftriaxone 7 days), transfuse restrictively (Hb \u2248 70\u201380 g/L), urgent OGD with banding; TIPS within 72 h in Child-Pugh B with active bleeding or C \u2264 13.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Ascites and SBP",
                listOf(
                    SubHeading("Ascites"),
                    Bullets(
                        listOf(
                            "Classification: grade 1 (mild, ultrasound), 2 (moderate, symmetrical distention), 3 (tense).",
                            "Management: sodium restriction (< 2 g/day), spironolactone + furosemide (ratio 100:40 mg), paracentesis for tense or refractory ascites with IV albumin 6\u20138 g per litre removed (> 5 L).",
                            "Refractory ascites: consider TIPS or transplant; avoid NSAIDs and ACE-I/ARB.",
                        )
                    ),
                    SubHeading("Spontaneous bacterial peritonitis (SBP)"),
                    Bullets(
                        listOf(
                            "Ascitic fluid neutrophil count \u2265 250 cells/mm\u00b3.",
                            "Empirical cefotaxime (or ceftriaxone / piperacillin-tazobactam in healthcare-associated) for 5\u20137 days.",
                            "IV albumin 1.5 g/kg day 1 + 1.0 g/kg day 3 reduces HRS and mortality.",
                            "Secondary prophylaxis: norfloxacin 400 mg daily (or ciprofloxacin) after first episode.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Every cirrhotic admitted with ascites needs a diagnostic paracentesis \u2014 SBP is often occult and missing it is fatal.",
                    ),
                ),
            ),
            TopicSection(
                "Hepatic encephalopathy (HE) & hepatorenal syndrome (HRS)",
                listOf(
                    Bullets(
                        listOf(
                            "HE triggers: infection, GI bleed, constipation, hypokalaemia, diuretic excess, sedatives, high-protein intake, TIPS.",
                            "First-line: lactulose titrated to 2\u20133 soft stools/day; rifaximin 550 mg BD for recurrent HE.",
                            "Protein restriction is NOT routinely recommended.",
                            "HRS type 1 (AKI-HRS): terlipressin + albumin; HRS type 2 (slowly progressive): bridge to transplant.",
                            "Transjugular intrahepatic portosystemic shunt (TIPS) for refractory ascites or recurrent variceal bleed \u2014 but can precipitate HE.",
                        )
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Do not give benzodiazepines for agitation in cirrhosis unless absolutely essential \u2014 they precipitate hepatic encephalopathy.",
                    ),
                ),
            ),
            TopicSection(
                "Hepatocellular carcinoma surveillance",
                listOf(
                    Bullets(
                        listOf(
                            "Six-monthly ultrasound \u00b1 AFP in all cirrhotic patients and non-cirrhotic chronic HBV with risk factors.",
                            "Diagnosis by imaging (LI-RADS 5) on contrast CT/MRI without biopsy in many cases.",
                            "Treatment: resection or transplant for early-stage; ablation, TACE for intermediate; tyrosine kinase inhibitors or immune checkpoint inhibitors (atezolizumab-bevacizumab) for advanced.",
                        ),
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Child-Pugh and MELD-Na stratify prognosis \u2014 MELD-Na drives transplant priority.",
            "All cirrhotics admitted with ascites require a diagnostic paracentesis \u2014 SBP kills silently.",
            "Albumin 1.5 g/kg day 1 + 1 g/kg day 3 reduces HRS and mortality in SBP.",
            "Terlipressin + albumin for HRS-AKI; transplant is the only cure.",
            "NSAIDs, ACE-I/ARB, aminoglycosides, contrast and nephrotoxins should be avoided in decompensated cirrhosis.",
            "Lactulose + rifaximin for recurrent HE; do not restrict protein.",
            "Give antibiotic prophylaxis and early TIPS (< 72 h) in high-risk variceal bleeding (Child-Pugh B with active bleeding, or C \u2264 13).",
            "Surveillance ultrasound every 6 months reduces HCC mortality.",
        ),
        qna = listOf(
            QnA(
                "Cirrhotic with ascites, fever, abdominal pain and ascitic neutrophil count 320/mm\u00b3 \u2014 treatment?",
                "IV ceftriaxone (or cefotaxime) + IV albumin 1.5 g/kg day 1 and 1 g/kg day 3.",
            ),
            QnA(
                "Acute variceal bleed in Child-Pugh B with active spurting after banding \u2014 next step?",
                "Consider early TIPS within 72 h; continue vasoactive therapy and prophylactic antibiotics.",
            ),
            QnA(
                "Which drug combination reduces mortality in AKI-HRS?",
                "Terlipressin plus albumin.",
            ),
        ),
    )

    private val ugib = Topic(
        id = "gi-upper-gib",
        title = "Upper GI Bleeding",
        subtitle = "Variceal and non-variceal",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 44 \u2014 Gastrointestinal bleeding"),
            TopicReference("Davidson 24e", "Ch. 23 \u2014 Gastroenterology (GI bleeding)"),
        ),
        sections = listOf(
            TopicSection(
                "Assessment",
                listOf(
                    Bullets(
                        listOf(
                            "Haematemesis, melaena, coffee-ground vomiting; haematochezia in massive upper bleed with rapid transit.",
                            "Glasgow-Blatchford score identifies low-risk patients (score = 0) suitable for outpatient management.",
                            "Rockall score (post-endoscopy) predicts rebleed and mortality.",
                            "Resuscitation priorities: airway, IV access (two large-bore), fluid resuscitation, transfuse restrictively (target Hb 70\u201380 g/L in most; 80\u201390 in IHD).",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Pre-endoscopic management",
                listOf(
                    Numbered(
                        listOf(
                            "If suspected variceal bleed: terlipressin 2 mg IV 4 hourly + prophylactic IV ceftriaxone 1 g daily for up to 7 days.",
                            "If suspected non-variceal: IV PPI (pantoprazole 80 mg bolus then 8 mg/h) only if high suspicion of peptic ulcer bleed; otherwise await endoscopy.",
                            "Reverse anticoagulants: prothrombin complex concentrate + vitamin K for warfarin; andexanet alfa or PCC for factor Xa inhibitors; idarucizumab for dabigatran.",
                            "Correct coagulopathy (platelets < 50, INR > 1.5); but do not transfuse platelets for aspirin-alone in non-major bleeds.",
                            "Urgent upper GI endoscopy within 24 h (< 12 h if unstable).",
                        )
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "Restrictive transfusion (Hb 70 g/L threshold) improves survival in UGIB (Villanueva trial), including most variceal bleeds.",
                    ),
                ),
            ),
            TopicSection(
                "Endoscopic therapy",
                listOf(
                    SubHeading("Non-variceal (peptic ulcer)"),
                    Bullets(
                        listOf(
                            "Dual therapy: adrenaline injection + either thermal coagulation or haemoclips.",
                            "Forrest Ia/Ib (active bleeding) and IIa (visible vessel) get endoscopic therapy; IIb (adherent clot) should be cleared.",
                            "After successful haemostasis: IV PPI infusion for 72 h; H. pylori testing and eradication if positive.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    SubHeading("Variceal"),
                    Bullets(
                        listOf(
                            "Oesophageal varices: endoscopic band ligation preferred over sclerotherapy.",
                            "Gastric varices (IGV1/GOV2): cyanoacrylate (glue) injection.",
                            "If bleeding uncontrolled: balloon tamponade (Sengstaken\u2013Blakemore) as a bridge to TIPS (maximum 24 h; intubate first).",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Rebleed & rescue therapy",
                listOf(
                    Bullets(
                        listOf(
                            "Rebleed: usually managed by repeat endoscopy; if fails, consider interventional radiology (transcatheter embolisation) for ulcer, TIPS for variceal.",
                            "Surgery reserved for failure of endoscopic and radiological treatment.",
                            "Post-discharge: test and eradicate H. pylori; resume antiplatelets cautiously (aspirin on day 1 in high CV risk), anticoagulants usually resumed within 7 days in high thrombotic risk.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Glasgow-Blatchford = 0 allows outpatient management of low-risk UGIB.",
            "Target Hb 70 g/L in haemodynamically stable UGIB \u2014 over-transfusion worsens portal pressure.",
            "Terlipressin + antibiotics for suspected variceal bleed before endoscopy.",
            "Ceftriaxone 7 days reduces bacterial infection and mortality in cirrhotic bleeders.",
            "Dual endoscopic therapy (adrenaline + clip or thermal) is superior to adrenaline alone for high-risk ulcers.",
            "Gastric varices respond better to cyanoacrylate (glue) than banding.",
            "TIPS within 72 h in high-risk variceal bleeders reduces rebleed and mortality.",
            "Resume aspirin for secondary prevention within 1\u20133 days after haemostasis \u2014 early withdrawal doubles cardiovascular events.",
        ),
        qna = listOf(
            QnA(
                "Cirrhotic with coffee-ground vomiting, HR 110, BP 95/60 \u2014 which two drugs before endoscopy?",
                "IV terlipressin and IV ceftriaxone.",
            ),
            QnA(
                "Post-band ligation, oesophageal varices rebleed within 24 h \u2014 rescue?",
                "Consider salvage TIPS; balloon tamponade as a bridge if needed.",
            ),
            QnA(
                "Stable UGIB from duodenal ulcer, high-risk stigmata, on aspirin for primary prevention \u2014 resume aspirin?",
                "For primary prevention, weigh risk; can usually stop. For secondary prevention, resume within 1\u20133 days after endoscopic haemostasis.",
            ),
        ),
    )

    val all: List<Topic> = listOf(cirrhosis, ugib)
}
