package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object RespiratoryTopics {

    private val copd = Topic(
        id = "resp-copd",
        title = "Chronic Obstructive Pulmonary Disease",
        subtitle = "COPD",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 293 \u2014 Chronic obstructive pulmonary disease"),
            TopicReference("Davidson 24e", "Ch. 17 \u2014 Respiratory disease (COPD)"),
        ),
        sections = listOf(
            TopicSection(
                "Definition & pathophysiology",
                listOf(
                    Paragraph(
                        "COPD is a preventable heterogeneous lung condition characterised by chronic respiratory symptoms (dyspnoea, cough, sputum) and persistent, often progressive, airflow limitation due to abnormalities of the airways (bronchitis, bronchiolitis) and/or alveoli (emphysema). Diagnosis requires post-bronchodilator FEV1/FVC < 0.70."
                    ),
                    Bullets(
                        listOf(
                            "Dominant risk factor in HICs is tobacco smoking; biomass smoke is a major cause globally.",
                            "Alpha-1 antitrypsin deficiency: early-onset, lower-lobe emphysema, non-smoker or minimal exposure.",
                            "Airway inflammation + mucus hypersecretion + small airway fibrosis + alveolar destruction \u2192 air trapping, dynamic hyperinflation.",
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Assessment",
                listOf(
                    SubHeading("GOLD ABE classification"),
                    Table(
                        title = "GOLD ABE groups (2023) \u2014 initial pharmacotherapy",
                        headers = listOf("Group", "Symptoms / Exacerbations", "Initial therapy"),
                        rows = listOf(
                            listOf("A", "mMRC 0\u20131, CAT < 10, \u2264 1 moderate exac/yr", "LAMA or LABA"),
                            listOf("B", "mMRC \u2265 2, CAT \u2265 10, \u2264 1 moderate exac/yr", "LAMA + LABA"),
                            listOf("E", "\u2265 2 moderate or \u2265 1 severe exac/yr", "LAMA + LABA; add ICS if eos \u2265 300"),
                        ),
                    ),
                    SubHeading("Spirometric severity (post-BD FEV1 % predicted)"),
                    Bullets(
                        listOf(
                            "GOLD 1 (mild): FEV1 \u2265 80 %.",
                            "GOLD 2 (moderate): 50\u201379 %.",
                            "GOLD 3 (severe): 30\u201349 %.",
                            "GOLD 4 (very severe): < 30 %.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Management \u2014 stable disease",
                listOf(
                    SubHeading("Non-pharmacological"),
                    Bullets(
                        listOf(
                            "Smoking cessation \u2014 the only intervention proven to slow FEV1 decline.",
                            "Influenza, pneumococcal, COVID-19 and pertussis vaccination.",
                            "Pulmonary rehabilitation \u2014 for anyone symptomatic or after exacerbation.",
                            "Long-term O2 \u2265 15 h/day if resting PaO2 \u2264 7.3 kPa (55 mmHg), or \u2264 8 kPa (60 mmHg) with polycythaemia, cor pulmonale or peripheral oedema.",
                        ),
                    ),
                    SubHeading("Inhaled therapy"),
                    Numbered(
                        listOf(
                            "Start LAMA or LABA (group A) or LAMA + LABA combination (group B, E).",
                            "Step up to triple therapy (LABA + LAMA + ICS) if further exacerbations and blood eosinophils \u2265 100 cells/\u03bcL \u2014 stronger benefit if \u2265 300.",
                            "For persistent exacerbations on triple therapy: consider roflumilast (chronic bronchitis, FEV1 < 50 %), azithromycin (in former smokers), or dupilumab (raised eosinophils, T2-high phenotype).",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Do not continue ICS in COPD with recurrent pneumonia and low eosinophils (< 100) \u2014 harm outweighs benefit; step down to LABA + LAMA.",
                    ),
                ),
            ),
            TopicSection(
                "Acute exacerbation",
                listOf(
                    SubHeading("Treatment"),
                    Numbered(
                        listOf(
                            "Nebulised salbutamol 2.5\u20135 mg + ipratropium 500 \u03bcg 4\u20136 hourly.",
                            "Prednisolone 30\u201340 mg PO daily for 5 days (no taper).",
                            "Antibiotic (amoxicillin or doxycycline 5 days) if \u2265 2 of: increased dyspnoea, sputum volume, sputum purulence \u2014 or if ventilated.",
                            "Controlled oxygen: SpO2 target 88\u201392 %; Venturi mask preferred \u2014 avoid hyperoxia.",
                            "Non-invasive ventilation (BiPAP) for respiratory acidosis (pH 7.25\u20137.35, PaCO2 > 6.5 kPa) after optimal medical therapy.",
                            "Invasive ventilation if pH < 7.25, coma, severe hypoxia, haemodynamic instability or NIV failure.",
                        )
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Hypercapnia in COPD is largely due to V/Q mismatch, not loss of hypoxic drive. Do not withhold oxygen; target 88\u201392 % and reassess ABG.",
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Post-BD FEV1/FVC < 0.70 is required to diagnose COPD \u2014 without spirometry there is no diagnosis.",
            "Smoking cessation is the only intervention that slows FEV1 decline.",
            "Long-term O2 improves survival when PaO2 \u2264 7.3 kPa; the benefit is lost if < 15 h/day.",
            "Blood eosinophils \u2265 300 predict ICS response; < 100 predicts minimal benefit and pneumonia risk.",
            "Triple therapy reduces exacerbations and mortality in frequent exacerbators with elevated eosinophils (IMPACT, ETHOS).",
            "Alpha-1 antitrypsin deficiency: young non-smoker with basal emphysema \u00b1 liver disease \u2014 serum level + phenotype.",
            "COPD exacerbation steroid course = 5 days, no taper (REDUCE).",
            "NIV in type 2 respiratory failure (pH 7.25\u20137.35) reduces intubation and mortality.",
        ),
        qna = listOf(
            QnA(
                "COPD patient, GOLD B, persistent dyspnoea on LAMA. Next step?",
                "Add LABA to form a LABA + LAMA combination (group B default).",
            ),
            QnA(
                "Frequent exacerbator on LABA + LAMA + ICS, still exacerbating, eosinophils 90 \u2014 options?",
                "Consider de-escalating ICS (low eosinophils) and adding azithromycin (former smoker) or roflumilast (chronic bronchitis, FEV1 < 50 %).",
            ),
            QnA(
                "Acute COPD exacerbation with pH 7.28, PaCO2 8.5 kPa after 1 h of nebulisers and controlled O2 \u2014 next step?",
                "Start NIV (BiPAP) on the ward or HDU with close monitoring.",
            ),
        ),
    )

    private val asthma = Topic(
        id = "resp-asthma",
        title = "Asthma",
        subtitle = "Chronic and acute management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 292 \u2014 Asthma"),
            TopicReference("Davidson 24e", "Ch. 17 \u2014 Respiratory disease (Asthma)"),
        ),
        sections = listOf(
            TopicSection(
                "Overview",
                listOf(
                    Paragraph(
                        "Asthma is a chronic inflammatory airway disease characterised by variable airflow obstruction and airway hyperresponsiveness. Diagnosis combines typical symptoms (episodic wheeze, cough, breathlessness, chest tightness \u2014 worse at night, with triggers, or diurnal variation) with evidence of variable expiratory airflow limitation: \u2265 12 % and 200 mL post-bronchodilator FEV1 reversibility, peak-flow variability, or FeNO \u2265 40 ppb (adults)."
                    ),
                    Bullets(
                        listOf(
                            "Type-2 (T2-high) asthma: eosinophilic, atopic, allergic, responds to ICS and biologics.",
                            "Non-T2 asthma: neutrophilic or paucigranulocytic, obesity-related, smoking-related \u2014 worse response to ICS.",
                            "Triggers: allergens, URTI, cold air, exercise, NSAIDs (aspirin-exacerbated respiratory disease), beta-blockers.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Stepwise chronic management (GINA 2023)",
                listOf(
                    Numbered(
                        listOf(
                            "Tracks: Track 1 (preferred) \u2014 ICS-formoterol reliever; Track 2 \u2014 SABA reliever + daily ICS controller.",
                            "Step 1\u20132: As-needed low-dose ICS-formoterol.",
                            "Step 3: Low-dose ICS-formoterol MART (maintenance + reliever).",
                            "Step 4: Medium-dose ICS-formoterol MART.",
                            "Step 5: Add LAMA (tiotropium) and/or refer for phenotyping and biologic therapy; consider add-on azithromycin.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    SubHeading("Biologics for severe T2 asthma"),
                    Bullets(
                        listOf(
                            "Omalizumab: anti-IgE \u2014 severe allergic asthma with sensitisation.",
                            "Mepolizumab, reslizumab: anti-IL-5.",
                            "Benralizumab: anti-IL-5R\u03b1.",
                            "Dupilumab: anti-IL-4R\u03b1 \u2014 T2-high asthma (eosinophils \u2265 150 or FeNO \u2265 25) and useful in steroid-dependence and nasal polyps.",
                            "Tezepelumab: anti-TSLP \u2014 benefits across phenotypes including non-eosinophilic severe asthma.",
                        )
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "SABA-only treatment is unsafe \u2014 associated with increased mortality. Every adult with asthma should be on an ICS-containing regimen.",
                    ),
                ),
            ),
            TopicSection(
                "Acute severe asthma",
                listOf(
                    SubHeading("Severity assessment"),
                    Table(
                        title = "Acute severity (adults)",
                        headers = listOf("Feature", "Severe", "Life-threatening"),
                        rows = listOf(
                            listOf("PEF (% best/predicted)", "33\u201350 %", "< 33 %"),
                            listOf("RR", "\u2265 25/min", "Silent chest, exhaustion, cyanosis"),
                            listOf("HR", "\u2265 110/min", "Bradycardia, hypotension"),
                            listOf("SpO2 (air)", "\u2265 92 %", "< 92 % or PaO2 < 8 kPa"),
                            listOf("ABG", "Usually normal / low CO2", "Normal or raised PaCO2 \u2192 near-fatal"),
                        ),
                    ),
                    SubHeading("Treatment"),
                    Numbered(
                        listOf(
                            "O2 to target SpO2 94\u201398 %.",
                            "Salbutamol 5 mg (with O2) + ipratropium 500 \u03bcg every 15\u201330 min initially, then 4\u20136 hourly.",
                            "Prednisolone 40\u201350 mg PO OR hydrocortisone 100 mg IV 6 hourly.",
                            "Magnesium sulfate 1.2\u20132 g IV over 20 min if poor response.",
                            "Consider aminophylline or IV salbutamol with critical-care input.",
                            "Intubation / ventilation if exhaustion, silent chest, rising PaCO2 or cardiac arrest.",
                        )
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "A \u2018normal\u2019 PaCO2 in an exhausted asthmatic means impending respiratory failure \u2014 escalate early.",
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Never treat asthma with SABA alone \u2014 always pair with ICS (GINA 2019 onwards).",
            "ICS-formoterol is now the preferred reliever and controller (Track 1).",
            "Aspirin-exacerbated respiratory disease (Samter\u2019s triad): asthma + nasal polyps + aspirin sensitivity.",
            "Normal CO2 in a tiring asthmatic = near-fatal asthma.",
            "Magnesium sulfate IV 1.2\u20132 g reduces admissions in severe asthma.",
            "Dupilumab works for severe T2 asthma and nasal polyps; tezepelumab works across phenotypes.",
            "FeNO \u2265 40 ppb supports eosinophilic airway inflammation and steroid responsiveness.",
            "Check adherence and inhaler technique before stepping up therapy.",
        ),
        qna = listOf(
            QnA(
                "Patient on low-dose ICS-formoterol MART still wakes 3 nights/week with wheeze \u2014 next step?",
                "Step up to medium-dose ICS-formoterol MART (Step 4).",
            ),
            QnA(
                "Acute asthma: PEF 30 % predicted, exhausted, PaCO2 5.3 kPa \u2014 significance?",
                "\u2018Normal\u2019 CO2 despite tachypnoea signals impending respiratory failure \u2014 ICU, magnesium, consider intubation.",
            ),
            QnA(
                "Severe asthma uncontrolled on high-dose ICS-LABA, eosinophils 480, FeNO 55 \u2014 biologic choice?",
                "Either mepolizumab/benralizumab (anti-IL5/5R) or dupilumab; dupilumab also if nasal polyps or steroid-dependence.",
            ),
        ),
    )

    private val pe = Topic(
        id = "resp-pe",
        title = "Pulmonary Embolism",
        subtitle = "Acute PE \u2014 diagnosis & management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 279 \u2014 Deep venous thrombosis & pulmonary embolism"),
            TopicReference("Davidson 24e", "Ch. 17 \u2014 Respiratory disease (Pulmonary thromboembolism)"),
        ),
        sections = listOf(
            TopicSection(
                "Risk factors & presentation",
                listOf(
                    Bullets(
                        listOf(
                            "Major: recent surgery, immobilisation, malignancy, pregnancy/puerperium, oestrogen therapy, previous VTE, inherited thrombophilia, antiphospholipid syndrome.",
                            "Presentation: dyspnoea (most common), pleuritic chest pain, haemoptysis, tachycardia, signs of DVT.",
                            "Massive PE: hypotension, syncope, RV strain on echo, refractory hypoxia.",
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Diagnosis",
                listOf(
                    SubHeading("Pre-test probability (Wells score)"),
                    Bullets(
                        listOf(
                            "Clinical signs of DVT (3), PE is the most likely diagnosis (3), HR > 100 (1.5), immobilisation/surgery in 4 weeks (1.5), previous PE/DVT (1.5), haemoptysis (1), malignancy active or within 6 months (1).",
                            "Two-level: likely > 4, unlikely \u2264 4.",
                        ),
                        source = TopicSource.Davidson,
                    ),
                    SubHeading("Pathway"),
                    Numbered(
                        listOf(
                            "If unstable: bedside echo for RV strain \u2192 if positive, treat as high-risk PE (thrombolysis) without waiting for CTPA.",
                            "If stable and PE likely: CTPA first-line; V/Q scan if contrast contraindicated or pregnancy (often with chest X-ray).",
                            "If stable and PE unlikely: D-dimer (age-adjusted cut-off \u2192 10 \u00d7 age if > 50). Negative excludes PE; positive \u2192 CTPA.",
                            "In pregnancy: unilateral leg compression US first if leg symptoms; if negative, V/Q scan or low-dose CTPA (consider breast radiation risk).",
                        )
                    ),
                    SubHeading("Severity stratification"),
                    Bullets(
                        listOf(
                            "High-risk (massive): hypotension or shock.",
                            "Intermediate-high: RV dysfunction on imaging AND elevated troponin/BNP.",
                            "Intermediate-low: RV dysfunction OR biomarker elevation.",
                            "Low-risk: no haemodynamic compromise, no RV strain, no biomarker elevation, sPESI 0 \u2014 consider outpatient management.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Anticoagulation"),
                    Bullets(
                        listOf(
                            "DOAC (apixaban or rivaroxaban) monotherapy preferred for most patients \u2014 no LMWH lead-in required.",
                            "LMWH for \u2265 5 days then dabigatran or edoxaban is an alternative.",
                            "Warfarin with LMWH bridging still preferred in antiphospholipid syndrome (triple-positive) and severe renal impairment (CrCl < 15).",
                            "LMWH preferred in pregnancy (warfarin teratogenic; DOACs contraindicated).",
                            "Cancer-associated VTE: DOAC (edoxaban or apixaban) now non-inferior to LMWH for most; LMWH for GI or luminal cancer risk.",
                        )
                    ),
                    SubHeading("Reperfusion & IVC filters"),
                    Bullets(
                        listOf(
                            "Systemic thrombolysis (alteplase 100 mg over 2 h) for high-risk PE or intermediate-high PE with deterioration.",
                            "Catheter-directed thrombolysis / thrombectomy when systemic lysis contraindicated.",
                            "IVC filter only if absolute contraindication to anticoagulation or recurrent PE on therapeutic anticoagulation.",
                        ),
                        source = TopicSource.Both,
                    ),
                    SubHeading("Duration of anticoagulation"),
                    Bullets(
                        listOf(
                            "Provoked PE (major transient risk factor): 3 months.",
                            "Unprovoked PE: at least 3 months, then assess bleeding risk and patient preference for indefinite extended anticoagulation (often reduced-dose DOAC, e.g. apixaban 2.5 mg BD or rivaroxaban 10 mg OD).",
                            "Recurrent unprovoked VTE or active cancer: indefinite.",
                            "Antiphospholipid syndrome: indefinite warfarin (INR 2\u20133).",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Haemodynamically unstable \u2192 bedside echo, thrombolysis; do not wait for CTPA.",
            "Age-adjusted D-dimer cut-off (10 \u00d7 age) increases specificity in > 50 y and safely rules out PE.",
            "DOAC monotherapy (apixaban/rivaroxaban) is now first-line for most PEs.",
            "Pregnancy: LMWH therapeutic dose; avoid DOACs and warfarin.",
            "Triple-positive antiphospholipid syndrome \u2192 warfarin, not DOAC (DOACs failed in TRAPS trial).",
            "Extended reduced-dose DOAC (apixaban 2.5 mg BD or rivaroxaban 10 mg OD) reduces VTE recurrence with minimal bleeding.",
            "sPESI = 0 \u2014 consider home treatment in selected PE.",
            "Active luminal GI cancer \u2192 LMWH preferred over DOAC for bleeding risk.",
        ),
        qna = listOf(
            QnA(
                "Hypotensive patient with syncope and right heart strain on bedside echo \u2014 management?",
                "High-risk PE \u2014 systemic thrombolysis (alteplase 100 mg over 2 h), fluid resuscitation, vasopressor support.",
            ),
            QnA(
                "Pregnant woman, leg swelling, pleuritic chest pain \u2014 next step?",
                "Leg compression ultrasound first; if positive, treat. If negative, V/Q scan (or low-dose CTPA) \u2014 treat with therapeutic LMWH.",
            ),
            QnA(
                "Unprovoked PE, first episode, low bleeding risk, patient prefers to continue therapy \u2014 duration?",
                "At least 3 months, then extended reduced-dose DOAC (e.g. apixaban 2.5 mg BD) indefinitely.",
            ),
        ),
    )

    val all: List<Topic> = listOf(copd, asthma, pe)
}
