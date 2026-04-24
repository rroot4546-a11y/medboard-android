package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object NephrologyTopics {

    private val aki = Topic(
        id = "neph-aki",
        title = "Acute Kidney Injury",
        subtitle = "KDIGO staging and management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 310 \u2014 Acute kidney injury"),
            TopicReference("Davidson 24e", "Ch. 15 \u2014 Nephrology & urology (Acute kidney injury)"),
        ),
        sections = listOf(
            TopicSection(
                "Definition & staging (KDIGO)",
                listOf(
                    Table(
                        title = "KDIGO stages",
                        headers = listOf("Stage", "Serum creatinine", "Urine output"),
                        rows = listOf(
                            listOf("1", "\u2191 \u2265 26.5 \u03bcmol/L in 48 h OR 1.5\u20131.9\u00d7 baseline", "< 0.5 mL/kg/h for 6\u201312 h"),
                            listOf("2", "2.0\u20132.9\u00d7 baseline", "< 0.5 mL/kg/h for \u2265 12 h"),
                            listOf("3", "\u2265 3\u00d7 baseline OR creatinine \u2265 354 \u03bcmol/L OR RRT initiated", "< 0.3 mL/kg/h \u2265 24 h or anuria \u2265 12 h"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Causes \u2014 pre-renal, intrinsic, post-renal",
                listOf(
                    Table(
                        title = "Aetiology framework",
                        headers = listOf("Category", "Examples"),
                        rows = listOf(
                            listOf("Pre-renal", "Hypovolaemia, sepsis, HF, hepatorenal, NSAIDs, ACE-I/ARB, cyclosporin"),
                            listOf("Intrinsic", "ATN (ischaemia/toxin), AIN (drug, infection, SLE), glomerulonephritis, vasculitis, TMA, rhabdomyolysis"),
                            listOf("Post-renal", "Prostatic obstruction, stones, retroperitoneal fibrosis, pelvic tumour"),
                        ),
                    ),
                    SubHeading("Useful clinical clues"),
                    Bullets(
                        listOf(
                            "Urinalysis: bland \u2192 pre-renal or obstruction; dysmorphic RBC + casts \u2192 glomerular; eosinophils \u2192 AIN; haemoglobinuria without RBCs \u2192 rhabdomyolysis or haemolysis.",
                            "Urine Na < 20 mmol/L and FeNa < 1 % suggest pre-renal (when not on diuretics).",
                            "Renal ultrasound: rule out obstruction; small kidneys suggest chronic disease.",
                            "Medication reconciliation: NSAIDs, ACE-I/ARB, diuretics, aminoglycosides, contrast, vancomycin, methotrexate.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    Numbered(
                        listOf(
                            "Treat cause: fluids for pre-renal AKI (crystalloid), antibiotics for sepsis, relieve obstruction.",
                            "Stop nephrotoxins; dose-adjust essential drugs.",
                            "Monitor urine output, daily weight, fluid balance, electrolytes.",
                            "Indications for RRT (AEIOU): refractory Acidosis, refractory Electrolyte disturbance (esp. hyperkalaemia), Ingestion (toxic alcohols, lithium, salicylate), fluid Overload refractory to diuretics, Uraemia (pericarditis, encephalopathy, bleeding).",
                        )
                    ),
                    SubHeading("Contrast-associated AKI"),
                    Bullets(
                        listOf(
                            "Incidence lower than previously thought with modern iso-osmolar contrast.",
                            "Hydration (0.9 % saline) before and after contrast remains key in those at risk (CKD, diabetes, hypotension).",
                            "N-acetylcysteine and isotonic bicarbonate not routinely recommended.",
                        ),
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Vancomycin + piperacillin-tazobactam increases AKI risk; consider cefepime or meropenem as alternatives when combined with vancomycin.",
                    ),
                ),
            ),
            TopicSection(
                "Hyperkalaemia (a common AKI emergency)",
                listOf(
                    Numbered(
                        listOf(
                            "ECG changes or K > 6.5: 10 % calcium gluconate 10 mL over 10 min (cardiac membrane stabilisation; repeat every 10\u201320 min until ECG improves).",
                            "Insulin 10 units in 25 g glucose (50 mL 50 % dextrose) IV over 15 min; monitor glucose hourly for 6 h.",
                            "Salbutamol 10\u201320 mg nebulised adjunct.",
                            "Bicarbonate 50\u2013100 mL 8.4 % if severe acidaemia.",
                            "Remove potassium: loop diuretic, sodium zirconium cyclosilicate / patiromer, dialysis if refractory.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "AKI mortality is high \u2014 even recovered AKI doubles the risk of future CKD.",
            "Always order urinalysis, urine microscopy and renal ultrasound early in AKI.",
            "Stop ACE-I/ARB/diuretics/NSAIDs in sepsis or acute volume depletion; restart once recovered.",
            "Balanced crystalloid (Plasma-Lyte, Hartmann's) preferred over 0.9 % saline for large-volume resuscitation (SMART).",
            "Calcium gluconate does not lower potassium \u2014 it buys time by stabilising myocardium.",
            "AKI + eosinophilia + rash + drug exposure = allergic interstitial nephritis.",
            "Rhabdomyolysis: CK > 5 \u00d7 ULN, dipstick positive for blood, no RBC on microscopy \u2014 volume resuscitate.",
            "RRT indication mnemonic: AEIOU.",
        ),
        qna = listOf(
            QnA(
                "Elderly patient with sepsis, creatinine rises from 80 to 220, UO 0.3 mL/kg/h over 8 h \u2014 stage?",
                "KDIGO stage 2 on UO criterion (< 0.5 mL/kg/h \u2265 12 h needed for stage 2 in full criterion, but 0.3 \u2265 24 h = stage 3); by creatinine 2.75\u00d7 baseline = stage 2.",
            ),
            QnA(
                "AKI with K 7.2 and peaked T waves \u2014 first drug?",
                "IV calcium gluconate 10 % 10 mL over 10 min.",
            ),
            QnA(
                "Which fluid in septic AKI \u2014 0.9 % saline or balanced crystalloid?",
                "Balanced crystalloid (e.g. Plasma-Lyte, Hartmann's) \u2014 SMART and SALT-ED trials show lower MAKE (major adverse kidney events).",
            ),
        ),
    )

    private val ckd = Topic(
        id = "neph-ckd",
        title = "Chronic Kidney Disease",
        subtitle = "Staging, progression and complications",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 311 \u2014 Chronic kidney disease"),
            TopicReference("Davidson 24e", "Ch. 15 \u2014 Nephrology & urology (CKD)"),
        ),
        sections = listOf(
            TopicSection(
                "Diagnosis & staging",
                listOf(
                    Paragraph(
                        "CKD is defined as abnormalities of kidney structure or function, present for > 3 months. Classification is by cause, eGFR category (G1\u2013G5) and albuminuria category (A1\u2013A3)."
                    ),
                    Table(
                        title = "eGFR categories",
                        headers = listOf("Stage", "eGFR (mL/min/1.73 m\u00b2)"),
                        rows = listOf(
                            listOf("G1", "\u2265 90 (normal with kidney damage)"),
                            listOf("G2", "60\u201389 (mild decrease)"),
                            listOf("G3a", "45\u201359 (mild-moderate)"),
                            listOf("G3b", "30\u201344 (moderate-severe)"),
                            listOf("G4", "15\u201329 (severe)"),
                            listOf("G5", "< 15 (kidney failure)"),
                        ),
                    ),
                    Table(
                        title = "Albuminuria (ACR)",
                        headers = listOf("Category", "mg/mmol", "mg/g"),
                        rows = listOf(
                            listOf("A1 (normal-mild)", "< 3", "< 30"),
                            listOf("A2 (moderate)", "3\u201330", "30\u2013300"),
                            listOf("A3 (severe)", "> 30", "> 300"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Slowing progression",
                listOf(
                    Numbered(
                        listOf(
                            "Blood-pressure target < 130/80 (KDIGO); first-line ACE-I or ARB in any CKD with albuminuria \u2014 titrate to the maximum tolerated dose.",
                            "SGLT2 inhibitor (dapagliflozin, empagliflozin) for diabetic or non-diabetic CKD with eGFR \u2265 20 and ACR \u2265 22.6 mg/mmol \u2014 DAPA-CKD, EMPA-KIDNEY.",
                            "Non-steroidal MRA (finerenone) in T2DM with albuminuric CKD on optimal ACE-I/ARB \u2014 FIDELIO.",
                            "Glycaemic and lipid control, smoking cessation, weight management, avoid nephrotoxic drugs.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "A 25\u201330 % rise in serum creatinine within the first 2 weeks of starting ACE-I/ARB is acceptable; do not stop unless greater than 30 %, K \u2265 6.0 or haemodynamic instability.",
                    ),
                ),
            ),
            TopicSection(
                "Complications & their management",
                listOf(
                    SubHeading("CKD-mineral and bone disorder (CKD-MBD)"),
                    Bullets(
                        listOf(
                            "Rising phosphate, FGF-23 and PTH; falling calcitriol \u2192 secondary hyperparathyroidism and renal osteodystrophy.",
                            "Dietary phosphate restriction; non-calcium-based phosphate binders (sevelamer, lanthanum) or calcium-based.",
                            "Active vitamin D analogue (alfacalcidol, calcitriol) if PTH elevated; calcimimetics (cinacalcet, etelcalcetide) for dialysis-dependent patients.",
                        )
                    ),
                    SubHeading("Anaemia"),
                    Bullets(
                        listOf(
                            "Assess iron stores first \u2014 target TSAT \u2265 20 %, ferritin > 100 (non-dialysis) or > 200 (haemodialysis).",
                            "Erythropoiesis-stimulating agents when Hb < 100 g/L and iron replete; target Hb 100\u2013120 g/L.",
                            "Hypoxia-inducible factor prolyl-hydroxylase inhibitors (roxadustat, daprodustat, vadadustat) are newer oral alternatives \u2014 watch for thrombotic events.",
                        )
                    ),
                    SubHeading("Other"),
                    Bullets(
                        listOf(
                            "Metabolic acidosis: sodium bicarbonate 600\u20131200 mg TDS aiming HCO3\u207b > 22 mmol/L.",
                            "Vaccinate: influenza, pneumococcal, hepatitis B (before CKD progresses to dialysis).",
                            "Avoid magnesium-containing laxatives, NSAIDs and OTC herbal remedies.",
                            "Refer to nephrology when eGFR < 30, rapid progression > 5 mL/min/yr, persistent A3 albuminuria, refractory hypertension or electrolyte disturbance.",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "SGLT2 inhibitors reduce CKD progression and mortality \u2014 use even in non-diabetic proteinuric CKD (DAPA-CKD, EMPA-KIDNEY).",
            "Finerenone adds benefit on top of ACE-I/ARB in diabetic albuminuric CKD (FIDELIO).",
            "Creatinine rise up to 30 % after starting ACE-I is acceptable.",
            "Target BP < 130/80 for most adults with CKD; avoid dual RAS blockade (ONTARGET).",
            "Anaemia of CKD: confirm iron repletion before starting ESA or HIF-PHI.",
            "Cinacalcet and paricalcitol for secondary hyperparathyroidism on dialysis.",
            "Gadolinium contrast is contraindicated at eGFR < 30 (nephrogenic systemic fibrosis).",
            "Start vascular access (AVF) planning at eGFR ~ 20 mL/min in progressive CKD.",
        ),
        qna = listOf(
            QnA(
                "Non-diabetic CKD G3a A3 on max-dose ACE-I \u2014 next step to slow progression?",
                "Add an SGLT2 inhibitor (dapagliflozin or empagliflozin).",
            ),
            QnA(
                "Diabetic CKD, creatinine rises 22 % two weeks after starting ramipril \u2014 stop the drug?",
                "No \u2014 continue; a rise up to 30 % is acceptable. Recheck and monitor potassium.",
            ),
            QnA(
                "CKD G4 with Hb 92, TSAT 15 %, ferritin 80 \u2014 next step?",
                "IV iron first; reassess Hb after iron repletion before starting ESA/HIF-PHI.",
            ),
        ),
    )

    val all: List<Topic> = listOf(aki, ckd)
}
