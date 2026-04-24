package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object EndocrinologyTopics {

    private val dm2 = Topic(
        id = "endo-dm2",
        title = "Type 2 Diabetes Mellitus",
        subtitle = "Diagnosis and modern management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 396\u2013399 \u2014 Diabetes mellitus"),
            TopicReference("Davidson 24e", "Ch. 21 \u2014 Diabetes mellitus (Type 2)"),
        ),
        sections = listOf(
            TopicSection(
                "Diagnosis",
                listOf(
                    Table(
                        title = "Diagnostic thresholds",
                        headers = listOf("Test", "Diabetes", "Pre-diabetes"),
                        rows = listOf(
                            listOf("HbA1c", "\u2265 48 mmol/mol (6.5 %)", "42\u201346 mmol/mol (6.0\u20136.4 %)"),
                            listOf("Fasting glucose", "\u2265 7.0 mmol/L", "6.1\u20136.9 (impaired fasting)"),
                            listOf("2-h OGTT 75 g", "\u2265 11.1 mmol/L", "7.8\u201311.0 (impaired glucose tolerance)"),
                            listOf("Random + symptoms", "\u2265 11.1 mmol/L", "\u2014"),
                        ),
                    ),
                    Paragraph(
                        "In the absence of symptoms of hyperglycaemia, diagnosis requires two abnormal tests (either two different days or two tests from the same sample). HbA1c is unreliable in haemoglobinopathies, recent blood loss, chronic kidney disease and iron-deficiency anaemia.",
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Glycaemic targets",
                listOf(
                    Bullets(
                        listOf(
                            "General HbA1c target: 53 mmol/mol (7.0 %); 48 mmol/mol (6.5 %) for younger patients on lifestyle \u00b1 metformin without hypoglycaemia risk.",
                            "Older / frail / high hypoglycaemia risk: 58\u201364 mmol/mol (7.5\u20138.0 %) \u2014 safety over tightness.",
                            "Continuous glucose monitoring: time-in-range > 70 % (target 3.9\u201310.0 mmol/L) with hypoglycaemia < 4 % of time.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Pharmacotherapy",
                listOf(
                    SubHeading("Choosing the second agent (individualise)"),
                    Numbered(
                        listOf(
                            "Established ASCVD, HF or albuminuric CKD \u2192 SGLT2 inhibitor or GLP-1 receptor agonist with proven benefit, independent of HbA1c.",
                            "Compelling need for weight loss or obesity-related comorbidity \u2192 GLP-1 RA (semaglutide, tirzepatide).",
                            "Minimise hypoglycaemia \u2192 DPP-4 inhibitor, SGLT2i, GLP-1 RA, pioglitazone (avoid if HF, fracture risk, bladder cancer).",
                            "Cost-sensitive context \u2192 metformin \u00b1 sulfonylurea.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    Table(
                        title = "Key agents \u2014 benefits & harms",
                        headers = listOf("Class", "Benefit", "Harm"),
                        rows = listOf(
                            listOf("Metformin", "Weight-neutral, no hypo, modest CV benefit", "GI upset, B12 deficiency, lactic acidosis (rare)"),
                            listOf("SGLT2 inhibitor", "CV, HF, renal protection, weight loss", "Euglycaemic DKA, genital infection, DKA risk if fasting/pre-op"),
                            listOf("GLP-1 RA", "CV benefit, significant weight loss", "GI, pancreatitis, contraindicated in MTC/MEN2 family history"),
                            listOf("Sulfonylurea", "Cheap, potent glucose lowering", "Hypoglycaemia, weight gain"),
                            listOf("Pioglitazone", "Insulin-sensitiser", "Fluid retention/HF, fractures, bladder cancer"),
                            listOf("Insulin", "Universal efficacy", "Hypoglycaemia, weight gain"),
                        ),
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Hold SGLT2 inhibitors for 3\u20134 days before major surgery or any significant fasting period to prevent euglycaemic DKA.",
                    ),
                ),
            ),
            TopicSection(
                "Complications & surveillance",
                listOf(
                    Bullets(
                        listOf(
                            "Annual review: HbA1c, BP, lipids, urine ACR, eGFR, foot exam, fundoscopy/retinal screen.",
                            "Blood-pressure target < 130/80 mmHg for most; first-line ACE-I/ARB if CKD or albuminuria.",
                            "Statin for primary prevention if QRISK/ASCVD \u2265 10 %, almost all age \u2265 40.",
                            "Diabetic foot: ischaemia, neuropathy, deformity \u2192 refer early for ulceration; daily inspection and appropriate footwear.",
                            "Neuropathy pharmacotherapy: duloxetine, amitriptyline, gabapentinoids; topical capsaicin.",
                        ),
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "First-line agent remains metformin unless contraindicated \u2014 but add SGLT2i/GLP-1 RA for CV, HF or renal indications irrespective of HbA1c.",
            "Empagliflozin reduces CV death, HF admissions and progression of CKD in T2DM (EMPA-REG, DAPA-HF, DAPA-CKD for dapagliflozin).",
            "Semaglutide and tirzepatide produce 10\u201320 % weight loss.",
            "Euglycaemic DKA can occur with SGLT2i during intercurrent illness or surgery \u2014 hold and check ketones.",
            "Hold metformin if eGFR < 30 or during AKI, contrast nephropathy risk or severe illness.",
            "Diabetic retinopathy screening annually from diagnosis in T2DM.",
            "Diabetic CKD: ACE-I/ARB + SGLT2 inhibitor + finerenone (if persistent albuminuria).",
            "Pioglitazone contraindicated in HFrEF and bladder cancer.",
        ),
        qna = listOf(
            QnA(
                "T2DM with HbA1c 62 on metformin, eGFR 60, ejection fraction 35 % \u2014 next agent?",
                "SGLT2 inhibitor (empagliflozin or dapagliflozin) \u2014 HFrEF benefit regardless of HbA1c.",
            ),
            QnA(
                "T2DM, BMI 42, HbA1c 70, established atherosclerotic CVD \u2014 preferred add-on?",
                "GLP-1 RA (semaglutide) or tirzepatide \u2014 CV benefit and substantial weight loss.",
            ),
            QnA(
                "Patient on SGLT2i presenting with abdominal pain and ketonuria with glucose 7 mmol/L \u2014 diagnosis?",
                "Euglycaemic DKA \u2014 stop SGLT2i, treat with IV fluids, insulin infusion and dextrose; check anion gap and ketones.",
            ),
        ),
    )

    private val dka = Topic(
        id = "endo-dka",
        title = "DKA & Hyperosmolar Hyperglycaemic State",
        subtitle = "Emergency management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 397 \u2014 Diabetic ketoacidosis and hyperglycaemic hyperosmolar state"),
            TopicReference("Davidson 24e", "Ch. 21 \u2014 Diabetes mellitus (Acute metabolic complications)"),
        ),
        sections = listOf(
            TopicSection(
                "Diagnosis",
                listOf(
                    Table(
                        title = "Diagnostic criteria",
                        headers = listOf("Parameter", "DKA", "HHS"),
                        rows = listOf(
                            listOf("Plasma glucose", "> 11 mmol/L (may be \u2018normal\u2019 in euglycaemic DKA)", "> 30 mmol/L"),
                            listOf("pH / bicarbonate", "pH < 7.3, HCO3\u207b < 15 mmol/L", "pH > 7.3, HCO3\u207b > 15"),
                            listOf("Ketones", "Capillary \u2265 3.0 or \u2265 2+ urine", "Absent / mild"),
                            listOf("Osmolality", "Variable", "> 320 mOsm/kg"),
                            listOf("Mental status", "Often alert", "Often altered"),
                        ),
                    ),
                    Paragraph(
                        "Both syndromes reflect relative/absolute insulin deficiency with counter-regulatory hormone excess, often precipitated by infection, missed insulin, new-onset diabetes, MI, pancreatitis, steroids, SGLT2 inhibitor therapy or drugs (cocaine, antipsychotics)."
                    ),
                ),
            ),
            TopicSection(
                "DKA management (adult, UK/international consensus)",
                listOf(
                    Numbered(
                        listOf(
                            "0.9 % saline 1 L IV STAT, then titrated (~4\u20134.5 L in first 12 h); individualise if cardiac or renal failure.",
                            "Fixed-rate IV insulin infusion: 0.1 units/kg/h \u2014 do NOT bolus. Continue long-acting basal analogue if already on one.",
                            "Monitor capillary ketones hourly \u2014 target fall \u2265 0.5 mmol/L/h (or HCO3\u207b rise \u2265 3 mmol/L/h, glucose fall \u2265 3 mmol/L/h).",
                            "Add 10 % dextrose once glucose < 14 mmol/L \u2014 continue insulin until ketones < 0.6 and pH > 7.3.",
                            "Potassium replacement: add 40 mmol KCl/L once K\u207a < 5.5; withhold insulin initially if K\u207a < 3.5.",
                            "Treat the precipitant (infection, MI, missed insulin); VTE prophylaxis.",
                            "Transition to subcutaneous insulin when eating and drinking; overlap IV and SC by at least 1 h.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Cerebral oedema is rare in adults but the leading cause of death in paediatric DKA; avoid overly rapid fluid correction and sodium changes.",
                    ),
                ),
            ),
            TopicSection(
                "HHS management",
                listOf(
                    Bullets(
                        listOf(
                            "Fluid first; many patients have 8\u201310 L deficit. Target osmolality fall of 3\u20138 mOsm/kg/h.",
                            "Begin insulin only after fluid resuscitation is underway and after 1 L saline \u2014 lower infusion rate (0.05 units/kg/h) once glucose plateaus.",
                            "Potassium and phosphate replacement; treat precipitant.",
                            "High VTE risk \u2014 therapeutic-dose or prophylactic anticoagulation as individualised.",
                            "Recovery can take 72 h; look for sepsis, silent MI and renal failure.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "DKA triad: acidosis, ketonaemia, hyperglycaemia (may be euglycaemic on SGLT2i).",
            "Start IV fluids first, then fixed-rate insulin 0.1 units/kg/h \u2014 no bolus, no sliding scale.",
            "Continue long-acting insulin during DKA to avoid rebound once IV insulin stops.",
            "Watch potassium: it falls as insulin drives K into cells \u2014 always replace early.",
            "Cerebral oedema is the leading DKA death in children; be cautious with fluid rate.",
            "Switch to variable-rate IV insulin if glucose falling too fast despite 10 % dextrose.",
            "Transition to SC basal-bolus with at least 1 h overlap; do not stop IV insulin prematurely.",
            "HHS: start insulin only after initial fluid and at lower rate (0.05 units/kg/h).",
        ),
        qna = listOf(
            QnA(
                "Patient with DKA: K 3.2 mmol/L on arrival. Do you start insulin now?",
                "No \u2014 correct potassium first. Give 40 mmol KCl in IV fluids; do not start insulin until K \u2265 3.5 to avoid life-threatening hypokalaemia.",
            ),
            QnA(
                "During DKA treatment glucose falls to 13 mmol/L but ketones still 2.8 \u2014 next step?",
                "Add 10 % dextrose to the fluid regimen and continue fixed-rate insulin until ketones < 0.6 and pH > 7.3.",
            ),
            QnA(
                "Elderly patient with T2DM, glucose 42 mmol/L, osmolality 345, minimal ketones \u2014 syndrome?",
                "Hyperosmolar hyperglycaemic state \u2014 aggressive fluids first, insulin at 0.05 u/kg/h once glucose no longer falls with fluid.",
            ),
        ),
    )

    private val thyroid = Topic(
        id = "endo-thyroid",
        title = "Thyroid Disease",
        subtitle = "Hypo-, hyperthyroidism and thyroid storm",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 383 \u2014 Disorders of the thyroid gland"),
            TopicReference("Davidson 24e", "Ch. 20 \u2014 Endocrine disease (Thyroid)"),
        ),
        sections = listOf(
            TopicSection(
                "Hypothyroidism",
                listOf(
                    Bullets(
                        listOf(
                            "Primary: Hashimoto's (autoimmune), iodine deficiency, post-surgery / radioiodine, amiodarone, lithium.",
                            "Subclinical: TSH raised, free T4 normal \u2014 treat if TSH > 10 mU/L, symptomatic, pregnant, or trying to conceive.",
                            "Replace with levothyroxine ~1.6 \u03bcg/kg/day (lower in elderly/IHD); titrate to TSH 0.5\u20132.5 mU/L (pregnancy target below).",
                            "Pregnancy: increase dose ~25\u201330 %; target TSH < 2.5 first trimester.",
                            "Myxoedema coma: hypothermia, hypoventilation, bradycardia, hyponatraemia \u2192 IV levothyroxine + hydrocortisone + supportive care.",
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Hyperthyroidism",
                listOf(
                    SubHeading("Causes"),
                    Table(
                        title = "Common causes",
                        headers = listOf("Condition", "Features", "Uptake scan"),
                        rows = listOf(
                            listOf("Graves disease", "Diffuse goitre, ophthalmopathy, TSH-receptor Ab", "Diffuse increased"),
                            listOf("Toxic multinodular goitre", "Nodular goitre, older age", "Patchy hot nodules"),
                            listOf("Toxic adenoma", "Single hyperfunctioning nodule", "Focal hot nodule"),
                            listOf("Subacute (De Quervain) thyroiditis", "Painful goitre post-viral, raised ESR", "Reduced / absent"),
                            listOf("Amiodarone-induced", "Type 1 iodine load vs type 2 destructive", "Reduced"),
                        ),
                    ),
                    SubHeading("Management"),
                    Bullets(
                        listOf(
                            "Beta-blocker (propranolol 40 mg QDS) for symptom control; avoid if asthmatic (use diltiazem).",
                            "Thionamide: carbimazole (first-line) or propylthiouracil (first-trimester pregnancy or thyroid storm).",
                            "Definitive: radioiodine or surgery \u2014 depending on age, goitre size, ophthalmopathy and patient preference.",
                            "Monitor for agranulocytosis: warn patients to stop drug and check FBC if sore throat or fever.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Thyroid storm",
                listOf(
                    Paragraph(
                        "Life-threatening exacerbation of thyrotoxicosis, often precipitated by infection, surgery, trauma, iodinated contrast or withdrawal of antithyroid drugs. Fever, tachyarrhythmia, heart failure, agitation, delirium and GI symptoms."
                    ),
                    Numbered(
                        listOf(
                            "Propranolol 1 mg IV (up to 10 mg) or 40\u201380 mg PO 6 hourly (avoid in HF unless under intensive monitoring).",
                            "Propylthiouracil 200 mg PO 4 hourly (preferred \u2014 blocks peripheral T4\u2192T3 conversion).",
                            "Potassium iodide (Lugol's) 1 h AFTER thionamide \u2014 Wolff-Chaikoff effect.",
                            "Hydrocortisone 100 mg IV 6 hourly \u2014 reduces peripheral conversion.",
                            "Cooling, supportive care, treat the precipitant (cultures, antibiotics if infection suspected).",
                            "Cholestyramine may help remove enterohepatic hormone; plasmapheresis is a rescue option.",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Treat subclinical hypothyroidism when TSH > 10, symptomatic, pregnant or planning pregnancy.",
            "TPO antibodies confirm autoimmune aetiology in Hashimoto's; TRAb specific for Graves.",
            "Graves ophthalmopathy worsens with smoking and radioiodine \u2014 warn patients and consider steroid cover.",
            "Carbimazole (or methimazole) is first-line; PTU reserved for 1st-trimester pregnancy and thyroid storm.",
            "Thyroid storm: give thionamide first, then iodine \u2265 1 h later to avoid iodine substrate feeding synthesis.",
            "Amiodarone thyrotoxicosis: type 1 (iodine load, multinodular gland) responds to thionamide; type 2 (destructive) responds to steroids.",
            "Sick euthyroid: low T3, normal TSH, transient \u2014 do not treat, repeat on recovery.",
            "Myxoedema coma mortality is high \u2014 give IV T4 plus hydrocortisone until adrenal insufficiency is excluded.",
        ),
        qna = listOf(
            QnA(
                "Pregnant woman, TSH 6.0, free T4 normal, TPO positive \u2014 management?",
                "Start levothyroxine; target trimester-specific TSH (< 2.5 first trimester).",
            ),
            QnA(
                "Graves' disease with moderate ophthalmopathy \u2014 preferred definitive treatment?",
                "Total thyroidectomy (or continued antithyroid drugs); radioiodine can worsen eye disease \u2014 use steroid cover if chosen.",
            ),
            QnA(
                "Thyroid storm: what is the correct order of drugs \u2014 iodine or PTU first?",
                "PTU (thionamide) first; iodine at least 1 h later to avoid providing iodine substrate for hormone synthesis.",
            ),
        ),
    )

    val all: List<Topic> = listOf(dm2, dka, thyroid)
}
