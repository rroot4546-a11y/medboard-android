package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

/**
 * Original board-revision summaries for cardiology.
 * Source texts studied: Harrison 21e + Davidson 24e (see citations on each topic).
 * No verbatim content from those books has been reproduced.
 */
internal object CardiologyTopics {

    private val acs = Topic(
        id = "card-acs",
        title = "Acute Coronary Syndromes",
        subtitle = "STEMI, NSTEMI and unstable angina",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 268 \u2013 Unstable angina & NSTEMI; Ch. 269 \u2013 ST-elevation MI"),
            TopicReference("Davidson 24e", "Ch. 16 \u2013 Cardiovascular disease (Acute coronary syndrome section)"),
        ),
        sections = listOf(
            TopicSection(
                "Overview & definitions",
                listOf(
                    Paragraph(
                        "Acute coronary syndrome (ACS) is the clinical syndrome that results from an abrupt reduction in " +
                            "coronary blood flow, almost always due to rupture or erosion of an atherosclerotic plaque with " +
                            "superimposed thrombus. Three clinical phenotypes are recognised based on the ECG and cardiac biomarkers."
                    ),
                    Table(
                        title = "ACS phenotypes",
                        headers = listOf("Phenotype", "ECG", "Troponin", "Typical mechanism"),
                        rows = listOf(
                            listOf("STEMI", "Persistent ST\u2191 / new LBBB", "Rises & falls", "Total occlusion of an epicardial artery"),
                            listOf("NSTEMI", "ST\u2193, T-wave inversion or normal", "Rises & falls", "Subtotal occlusion / distal embolisation"),
                            listOf("Unstable angina", "ST\u2193, T-wave inversion or normal", "Normal", "Plaque instability without myocyte necrosis"),
                        ),
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "The 4th Universal Definition of Myocardial Infarction requires a rise and/or fall of troponin with at least one value above the 99th-percentile upper reference limit, AND one of: ischaemic symptoms, new ischaemic ECG changes, new pathological Q waves, imaging evidence of new loss of viable myocardium, or identification of coronary thrombus at angiography/autopsy."
                    ),
                ),
            ),
            TopicSection(
                "Clinical features",
                listOf(
                    Bullets(
                        listOf(
                            "Central crushing chest pain \u2265 20 min, often radiating to left arm, jaw or epigastrium.",
                            "Autonomic features: diaphoresis, nausea, vomiting.",
                            "Atypical presentations in diabetes, elderly, women and post-operative patients \u2013 breathlessness, confusion, syncope, \u2018silent\u2019 MI.",
                            "Examination: often unremarkable; look for signs of heart failure (S3, crackles), new murmurs (acute MR, VSD), cardiogenic shock (cool peripheries, hypotension).",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Investigations",
                listOf(
                    SubHeading("12-lead ECG \u2013 obtain within 10 min of first medical contact"),
                    Bullets(
                        listOf(
                            "ST\u2191 \u2265 1 mm in \u2265 2 contiguous limb leads, or \u2265 2 mm in V2\u2013V3 (\u2265 1.5 mm in women), or new LBBB \u2013 treat as STEMI.",
                            "Posterior MI: tall R waves and ST\u2193 in V1\u2013V3; confirm with posterior leads V7\u2013V9.",
                            "RV infarction: ST\u2191 in V4R (obtain right-sided leads in inferior STEMI).",
                            "Sgarbossa criteria help diagnose MI in the presence of LBBB or paced rhythm.",
                        )
                    ),
                    SubHeading("Biomarkers"),
                    Paragraph(
                        "High-sensitivity cardiac troponin (hs-cTn) at 0 h and 1\u20133 h; algorithms (e.g. ESC 0/1 h) rule in or rule out MI in most patients. A single undetectable hs-cTn at presentation with symptoms \u2265 3 h and a low-risk clinical score can rule out MI."
                    ),
                    SubHeading("Other"),
                    Bullets(
                        listOf(
                            "Bloods: FBC, U&E, glucose, lipid profile, HbA1c, TSH, coagulation.",
                            "Echocardiogram: regional wall-motion abnormality, LV function, mechanical complications.",
                            "CXR, consider CT aorta if dissection in the differential.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Immediate measures (all ACS)"),
                    Bullets(
                        listOf(
                            "Oxygen only if SpO\u2082 < 90 %.",
                            "Pain relief \u2013 IV morphine or diamorphine with antiemetic; GTN (if systolic BP > 90 mmHg, no RV infarct or recent PDE-5 inhibitor use).",
                            "Dual antiplatelet therapy: aspirin 300 mg loading, plus a P2Y12 inhibitor (ticagrelor 180 mg or prasugrel 60 mg; clopidogrel 300\u2013600 mg if others contraindicated).",
                            "Parenteral anticoagulation: unfractionated heparin or fondaparinux / enoxaparin.",
                            "High-intensity statin (e.g. atorvastatin 80 mg) started early.",
                        )
                    ),
                    SubHeading("STEMI \u2013 reperfusion"),
                    Numbered(
                        listOf(
                            "Primary PCI is first-line if achievable within 120 min of first medical contact.",
                            "If PCI not available in that window, give fibrinolysis (e.g. tenecteplase, weight-adjusted) within 30 min of presentation, then transfer for PCI (rescue PCI if failed lysis, routine PCI within 2\u201324 h otherwise).",
                            "Absolute contraindications to lysis include previous haemorrhagic stroke, ischaemic stroke < 6 months, active bleeding, recent major surgery/head trauma, known bleeding diathesis, aortic dissection.",
                        )
                    ),
                    SubHeading("NSTEMI / unstable angina \u2013 risk-stratified invasive strategy"),
                    Table(
                        title = "Invasive timing after NSTEMI (GRACE-guided)",
                        headers = listOf("Risk", "GRACE / features", "Angiography timing"),
                        rows = listOf(
                            listOf("Very high", "Haemodynamic/electrical instability, ongoing ischaemia, mechanical complication", "Immediate (<2 h)"),
                            listOf("High", "GRACE > 140, dynamic ST/T changes, troponin rise/fall", "Early (<24 h)"),
                            listOf("Intermediate", "GRACE 109\u2013140, diabetes, CKD, prior PCI/CABG", "Within 72 h"),
                            listOf("Low", "No high-risk features, negative serial troponin", "Selective / non-invasive testing"),
                        ),
                    ),
                    SubHeading("Secondary prevention \u2013 start before discharge"),
                    Bullets(
                        listOf(
                            "Aspirin lifelong + P2Y12 inhibitor for 12 months (shorter if high bleeding risk).",
                            "High-intensity statin aiming LDL-C < 1.4 mmol/L (< 55 mg/dL).",
                            "ACE-inhibitor (or ARB) \u2013 particularly if LV dysfunction, diabetes, hypertension or CKD.",
                            "Beta-blocker \u2013 especially with LV dysfunction.",
                            "Eplerenone if LVEF \u2264 40 % with heart failure or diabetes.",
                            "Lifestyle: smoking cessation, Mediterranean diet, cardiac rehabilitation, BP and glycaemic targets.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Complications",
                listOf(
                    Bullets(
                        listOf(
                            "Arrhythmias: VF/VT (first 48 h), AF, bradyarrhythmia especially in inferior MI.",
                            "Heart failure / cardiogenic shock \u2013 Killip classification predicts mortality.",
                            "Mechanical: papillary muscle rupture (acute MR), ventricular septal rupture, free-wall rupture / tamponade \u2013 typically day 3\u20137.",
                            "Dressler syndrome: autoimmune pericarditis 2\u20136 weeks post-MI.",
                            "LV thrombus, especially with anterior STEMI and apical akinesia.",
                        )
                    ),
                    Callout(CalloutKind.Warning, "New loud pan-systolic murmur with pulmonary oedema after MI \u2013 think papillary muscle rupture (posterior PM is supplied by PDA alone, more vulnerable). Urgent echo and surgery."),
                ),
            ),
        ),
        boardPearls = listOf(
            "Troponin rise with a fall is needed for MI diagnosis; a single elevated value alone is not enough.",
            "In LBBB or paced rhythm, apply Sgarbossa criteria to diagnose acute MI.",
            "Inferior STEMI \u2013 always do right-sided and posterior leads.",
            "Avoid nitrates in RV infarction and sildenafil use within 24 h (48 h for tadalafil).",
            "Prasugrel is contraindicated after previous stroke/TIA and over age 75 or < 60 kg.",
            "Ticagrelor requires a lower aspirin maintenance dose (75 mg).",
            "Primary PCI beats lysis if achievable within 120 min of first medical contact.",
            "Cardiogenic shock after MI \u2013 early revascularisation reduces mortality (SHOCK trial).",
            "Start high-intensity statin before discharge regardless of baseline LDL.",
            "LVEF \u2264 40 % after MI with symptoms/diabetes \u2192 add an MRA (eplerenone).",
            "Wellens\u2019 syndrome (deep symmetrical T inversion in V2\u2013V3) represents a critical proximal LAD stenosis, not MI \u2013 do not stress test, send for angiography.",
            "Cocaine-induced ACS \u2013 benzodiazepines first; avoid non-selective beta-blockers (unopposed \u03b1).",
        ),
        qna = listOf(
            QnA(
                "Anterior STEMI \u2013 which artery is occluded?",
                "Left anterior descending (LAD). Proximal LAD occlusion causes ST\u2191 V1\u2013V6 with I/aVL involvement.",
            ),
            QnA(
                "ST\u2191 in II, III, aVF with bradycardia and hypotension \u2013 next test?",
                "Right-sided ECG (V4R) looking for RV involvement. Manage with fluids, not nitrates.",
            ),
            QnA(
                "After primary PCI, what duration of DAPT for a drug-eluting stent in a stable patient?",
                "12 months (aspirin + P2Y12 inhibitor), then aspirin alone lifelong.",
            ),
            QnA(
                "What is the Killip class for rales up to half-way up the lung fields?",
                "Killip III (pulmonary oedema); approximately 35\u201340 % 30-day mortality if untreated.",
            ),
            QnA(
                "When should fibrinolysis be preferred over PCI?",
                "When primary PCI cannot be delivered within 120 minutes of first medical contact and there are no contraindications to lytic therapy.",
            ),
            QnA(
                "A patient 5 days after inferior STEMI develops a new harsh pan-systolic murmur and shock \u2013 diagnosis?",
                "Ventricular septal rupture (or papillary muscle rupture). Urgent echo, IABP/Impella, and surgical repair.",
            ),
            QnA(
                "Post-MI LVEF 30 %, NYHA II. Which drug class is added to ACE-I + beta-blocker to reduce mortality?",
                "Mineralocorticoid receptor antagonist (e.g. eplerenone) \u2013 EPHESUS trial.",
            ),
        ),
    )

    private val heartFailure = Topic(
        id = "card-hf",
        title = "Heart Failure",
        subtitle = "HFrEF, HFmrEF and HFpEF",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 257 \u2013 Heart failure: pathophysiology & diagnosis; Ch. 258 \u2013 Management"),
            TopicReference("Davidson 24e", "Ch. 16 \u2013 Cardiovascular disease (Heart failure section)"),
        ),
        sections = listOf(
            TopicSection(
                "Definitions",
                listOf(
                    Paragraph(
                        "Heart failure is a clinical syndrome caused by a structural or functional cardiac abnormality, " +
                            "resulting in a reduced cardiac output and/or elevated filling pressures at rest or with stress. " +
                            "It is classified by ejection fraction and by time course."
                    ),
                    Table(
                        title = "Ejection-fraction classification",
                        headers = listOf("Category", "LVEF", "Typical features"),
                        rows = listOf(
                            listOf("HFrEF", "\u2264 40 %", "Reduced systolic function; most evidence for disease-modifying therapy"),
                            listOf("HFmrEF", "41\u201349 %", "Mildly reduced; treatment similar to HFrEF"),
                            listOf("HFpEF", "\u2265 50 %", "Preserved EF with diastolic dysfunction and raised filling pressure"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Aetiology",
                listOf(
                    Bullets(
                        listOf(
                            "Coronary artery disease (most common overall).",
                            "Hypertension (especially HFpEF).",
                            "Valvular disease \u2013 aortic stenosis, mitral regurgitation.",
                            "Cardiomyopathies \u2013 dilated, hypertrophic, restrictive, peripartum, tako-tsubo.",
                            "Arrhythmia-induced \u2013 persistent AF, frequent PVCs.",
                            "Toxic \u2013 alcohol, anthracyclines, trastuzumab, cocaine.",
                            "High-output \u2013 anaemia, thyrotoxicosis, beriberi, AV fistula, Paget\u2019s.",
                            "Infiltrative \u2013 amyloidosis (especially transthyretin in elderly), sarcoidosis, haemochromatosis.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Clinical features & investigations",
                listOf(
                    Paragraph(
                        "Symptoms \u2013 exertional breathlessness, orthopnoea, paroxysmal nocturnal dyspnoea, fatigue, ankle swelling. " +
                            "Signs \u2013 raised JVP, displaced apex, S3 gallop, bibasal crackles, hepatomegaly, pitting oedema, pleural effusions."
                    ),
                    SubHeading("NYHA functional class"),
                    Table(
                        title = null,
                        headers = listOf("Class", "Limitation"),
                        rows = listOf(
                            listOf("I", "No limitation of ordinary activity"),
                            listOf("II", "Slight limitation; symptoms with ordinary activity"),
                            listOf("III", "Marked limitation; symptoms with less-than-ordinary activity"),
                            listOf("IV", "Symptoms at rest"),
                        ),
                    ),
                    SubHeading("Key investigations"),
                    Bullets(
                        listOf(
                            "ECG \u2013 rarely normal; looks for ischaemia, LVH, AF, LBBB (consideration for CRT).",
                            "Natriuretic peptides \u2013 NT-proBNP > 125 pg/mL (non-acute) or > 300 pg/mL (acute) makes HF likely; a normal value has high negative predictive value.",
                            "Transthoracic echo \u2013 defines EF, chamber sizes, wall motion, valves, filling pressures (E/e\u2032), pericardium.",
                            "CXR \u2013 cardiomegaly, upper-lobe diversion, Kerley B lines, alveolar oedema, pleural effusions.",
                            "Cardiac MRI if echo inconclusive, or to look for infiltration / myocarditis.",
                            "Targeted investigation for reversible cause \u2013 ferritin/transferrin sats, TFTs, HIV, pregnancy test, genetic testing, endomyocardial biopsy in selected cases.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Chronic HFrEF \u2013 disease-modifying therapy (\u201cfour pillars\u201d)",
                listOf(
                    Table(
                        title = "Core HFrEF therapy",
                        headers = listOf("Class", "Example", "Key point"),
                        rows = listOf(
                            listOf("ARNI or ACE-I / ARB", "Sacubitril-valsartan", "ARNI preferred in HFrEF (PARADIGM-HF); do not start < 36 h after an ACE-I."),
                            listOf("Beta-blocker", "Bisoprolol, carvedilol, nebivolol", "Start low, titrate slowly; avoid in decompensated wet HF."),
                            listOf("MRA", "Spironolactone, eplerenone", "Monitor K\u207a and renal function; eplerenone fewer anti-androgen effects."),
                            listOf("SGLT2 inhibitor", "Dapagliflozin, empagliflozin", "Benefit independent of diabetes; watch for euglycaemic DKA and genital infections."),
                        ),
                    ),
                    SubHeading("Additional options"),
                    Bullets(
                        listOf(
                            "Loop diuretic for congestion (does not improve mortality).",
                            "Ivabradine if sinus rhythm, HR \u2265 70 bpm on maximally tolerated beta-blocker.",
                            "Hydralazine + isosorbide dinitrate for Black patients with persistent symptoms, or if ACE-I/ARB not tolerated.",
                            "Digoxin for symptom control (DIG trial \u2013 no mortality benefit).",
                            "Vericiguat or omecamtiv mecarbil in selected patients.",
                            "Intravenous iron (ferric carboxymaltose) if ferritin < 100 or 100\u2013299 with TSAT < 20 %.",
                        )
                    ),
                    SubHeading("Device therapy"),
                    Bullets(
                        listOf(
                            "ICD \u2013 primary prevention if LVEF \u2264 35 % despite 3 months of optimal medical therapy (OMT), NYHA II\u2013III, life expectancy > 1 year.",
                            "CRT (biventricular pacing) \u2013 LVEF \u2264 35 %, sinus rhythm, LBBB with QRS \u2265 150 ms (or 130\u2013149 ms), NYHA II\u2013IV on OMT.",
                            "LVAD / transplantation for advanced (stage D) heart failure.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "HFpEF",
                listOf(
                    Bullets(
                        listOf(
                            "Target comorbidities: hypertension, atrial fibrillation, obesity, CKD, diabetes.",
                            "SGLT2 inhibitors (dapagliflozin, empagliflozin) reduce HF hospitalisation across the full EF spectrum.",
                            "Loop diuretics for congestion.",
                            "Screen for cardiac amyloidosis (bone scintigraphy; red-flag features \u2013 low QRS voltage with LVH, carpal tunnel, autonomic symptoms).",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Acute decompensated HF",
                listOf(
                    Numbered(
                        listOf(
                            "Sit the patient up, high-flow oxygen if SpO\u2082 < 90 %, consider non-invasive ventilation (CPAP) for pulmonary oedema.",
                            "IV loop diuretic (e.g. furosemide 40 mg IV; doubled if already on oral loop).",
                            "GTN infusion if systolic BP > 110 mmHg and significant congestion.",
                            "Treat the precipitant \u2013 ischaemia, arrhythmia, non-compliance, infection, anaemia, uncontrolled BP, thyroid disease.",
                            "Reserve inotropes and vasopressors for cardiogenic shock (hypoperfusion despite adequate filling).",
                            "Restart disease-modifying therapy as soon as stable \u2013 early initiation and titration improves outcomes (STRONG-HF).",
                        )
                    ),
                    Callout(CalloutKind.Pitfall, "Beta-blockers are typically continued during decompensation if not hypotensive/shocked \u2013 only stop if in cardiogenic shock."),
                ),
            ),
        ),
        boardPearls = listOf(
            "The four pillars of HFrEF therapy are ARNI, beta-blocker, MRA and SGLT2 inhibitor \u2013 all four should be initiated and up-titrated early.",
            "Sacubitril-valsartan must not be started within 36 h of an ACE-inhibitor (angio-oedema risk).",
            "Ivabradine only works in sinus rhythm, HR \u2265 70 bpm.",
            "CRT-P/D is indicated in LBBB with QRS \u2265 150 ms, LVEF \u2264 35 % on OMT.",
            "ICD for primary prevention \u2013 LVEF \u2264 35 % after 3 months OMT, NYHA II\u2013III.",
            "Cardiogenic shock \u2013 do not start/continue beta-blocker; inotropes + mechanical support.",
            "BNP/NT-proBNP is reduced by obesity, ARNI initially raises BNP (neprilysin-substrate); interpret NT-proBNP instead.",
            "HFpEF \u2013 SGLT2 inhibitors reduce HF hospitalisations; diuretics for symptoms.",
            "Look for amyloidosis in elderly HFpEF with low-voltage ECG + LVH \u2013 technetium pyrophosphate scan is key.",
            "Screen for iron deficiency in HF regardless of anaemia; IV iron improves symptoms.",
            "Furosemide effect is blunted by NSAIDs and by heavily proteinuric states \u2013 may need combination diuretics.",
        ),
        qna = listOf(
            QnA(
                "First-line diuretic for symptomatic HFrEF with volume overload?",
                "Loop diuretic (furosemide, bumetanide, torsemide) \u2013 relieves symptoms; no mortality benefit.",
            ),
            QnA(
                "Patient with HFrEF (LVEF 30 %) on maximally tolerated ACE-I, beta-blocker and MRA remains NYHA II with sinus rhythm and HR 80 bpm \u2013 next step?",
                "Switch ACE-I to sacubitril-valsartan and add an SGLT2 inhibitor; consider ivabradine if still symptomatic with HR \u2265 70.",
            ),
            QnA(
                "Which HF population benefits least from ARNI?",
                "Patients who cannot tolerate adequate doses because of hypotension or angio-oedema; in severe renal impairment (eGFR < 30) use with caution.",
            ),
            QnA(
                "QRS 100 ms, LVEF 30 %, NYHA III on OMT \u2013 is CRT indicated?",
                "No \u2013 CRT benefit increases with QRS width; standard indication requires \u2265 130 ms, strongest if \u2265 150 ms and LBBB.",
            ),
            QnA(
                "Key mortality-lowering therapy specific to HFrEF in Black patients intolerant of ACE-I?",
                "Hydralazine + isosorbide dinitrate (A-HeFT trial).",
            ),
            QnA(
                "Elderly man, HFpEF, low-voltage ECG, LVH on echo, bilateral carpal-tunnel history \u2013 diagnosis?",
                "Transthyretin cardiac amyloidosis (ATTR). Confirm with Tc-99m pyrophosphate scan; tafamidis disease-modifying.",
            ),
        ),
    )

    private val af = Topic(
        id = "card-af",
        title = "Atrial Fibrillation",
        subtitle = "Rate, rhythm and stroke prevention",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 246 \u2013 Supraventricular tachyarrhythmias"),
            TopicReference("Davidson 24e", "Ch. 16 \u2013 Cardiovascular disease (Arrhythmias section)"),
        ),
        sections = listOf(
            TopicSection(
                "Classification",
                listOf(
                    Bullets(
                        listOf(
                            "First-diagnosed \u2013 any first episode irrespective of duration.",
                            "Paroxysmal \u2013 self-terminates within 7 days, usually within 48 h.",
                            "Persistent \u2013 > 7 days or requires cardioversion to terminate.",
                            "Long-standing persistent \u2013 > 1 year with rhythm-control still planned.",
                            "Permanent \u2013 rhythm control is no longer pursued.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Aetiology and precipitants",
                listOf(
                    Bullets(
                        listOf(
                            "Hypertension, coronary disease, heart failure (structural heart disease is the dominant substrate).",
                            "Valvular disease \u2013 particularly mitral stenosis (classically rheumatic).",
                            "Thyrotoxicosis, sepsis, pneumonia, PE (always look for a trigger in new AF).",
                            "Alcohol (\u201choliday heart\u201d), caffeine, sympathomimetics, cocaine.",
                            "Obstructive sleep apnoea \u2013 under-recognised, screen routinely.",
                            "Post-cardiac surgery \u2013 AF in the first week is common and usually self-limited.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Management framework \u2013 the \u201cCC to ABC\u201d pathway",
                listOf(
                    Numbered(
                        listOf(
                            "Confirm the rhythm on a 12-lead ECG and characterise with 2D echo.",
                            "A \u2013 Anticoagulation / Avoid stroke, using CHA\u2082DS\u2082-VASc and HAS-BLED.",
                            "B \u2013 Better symptom control with rate and/or rhythm management.",
                            "C \u2013 Cardiovascular risk factor and Comorbidity management (HTN, HF, OSA, alcohol, obesity).",
                        )
                    ),
                    Table(
                        title = "CHA\u2082DS\u2082-VASc score",
                        headers = listOf("Risk factor", "Points"),
                        rows = listOf(
                            listOf("Congestive heart failure", "1"),
                            listOf("Hypertension", "1"),
                            listOf("Age \u2265 75", "2"),
                            listOf("Diabetes mellitus", "1"),
                            listOf("Stroke/TIA/thromboembolism", "2"),
                            listOf("Vascular disease (CAD, PAD, aortic plaque)", "1"),
                            listOf("Age 65\u201374", "1"),
                            listOf("Sex category (female)", "1"),
                        ),
                    ),
                    Paragraph(
                        "Anticoagulate if CHA\u2082DS\u2082-VASc \u2265 2 (men) or \u2265 3 (women); consider if score 1 in men or 2 in women. A direct oral anticoagulant (apixaban, rivaroxaban, edoxaban, dabigatran) is preferred over warfarin unless the patient has moderate-to-severe mitral stenosis or a mechanical heart valve \u2013 both mandate warfarin."
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "HAS-BLED identifies modifiable bleeding risk but should NOT be used to withhold anticoagulation; it guides mitigation (control BP, stop NSAIDs/alcohol, review concomitant antiplatelets)."
                    ),
                ),
            ),
            TopicSection(
                "Rate vs rhythm control",
                listOf(
                    SubHeading("Rate control"),
                    Bullets(
                        listOf(
                            "First-line drugs: beta-blocker or non-dihydropyridine calcium-channel blocker (diltiazem / verapamil).",
                            "Add digoxin in sedentary elderly or if HFrEF.",
                            "Target resting HR < 110 bpm (lenient) is generally adequate; aim < 80 bpm if symptoms persist or LV dysfunction (strict).",
                            "Avoid verapamil/diltiazem in HFrEF; avoid pre-excitation drugs in WPW + AF (see below).",
                        )
                    ),
                    SubHeading("Rhythm control"),
                    Bullets(
                        listOf(
                            "Electrical cardioversion for haemodynamic instability or first-line strategy in young patients with symptomatic AF.",
                            "Pharmacological cardioversion \u2013 flecainide or propafenone (contraindicated in structural/ischaemic heart disease), amiodarone in structural heart disease.",
                            "Catheter ablation (pulmonary-vein isolation) is first-line rhythm control in symptomatic paroxysmal AF and reduces progression; superior to drugs in early AF and HF (EAST-AFNET 4, CASTLE-AF).",
                            "Always anticoagulate \u2265 3 weeks before and \u2265 4 weeks after cardioversion (or TOE-guided if urgent).",
                        )
                    ),
                    SubHeading("AF with pre-excitation (WPW)"),
                    Callout(CalloutKind.Pitfall, "In AF + WPW do NOT give AV-nodal blockers (adenosine, digoxin, verapamil, diltiazem, beta-blockers) \u2013 they can accelerate conduction down the accessory pathway and cause VF. Use procainamide, ibutilide, flecainide, or DC cardioversion."),
                ),
            ),
        ),
        boardPearls = listOf(
            "DOACs are preferred over warfarin in non-valvular AF; warfarin is mandatory in mechanical valves and moderate-to-severe mitral stenosis.",
            "New AF \u2013 always rule out thyroid disease, PE and sepsis.",
            "CHA\u2082DS\u2082-VASc drives the anticoagulation decision; HAS-BLED guides risk reduction, not withholding of treatment.",
            "Lenient rate control (< 110 bpm) is as effective as strict in most patients (RACE II).",
            "Pulmonary vein isolation is first-line rhythm control in symptomatic paroxysmal AF and in selected HFrEF patients.",
            "Anticoagulate \u2265 3 weeks pre-cardioversion and \u2265 4 weeks post (or use TOE-guided short-term approach).",
            "Apixaban is the preferred DOAC in CKD (dose-adjust at eGFR 15\u201329); avoid dabigatran in CrCl < 30.",
            "Left-atrial appendage occlusion (Watchman) is an option if long-term anticoagulation is contraindicated.",
            "New LV dysfunction in persistent AF with fast rate \u2013 consider arrhythmia-induced cardiomyopathy; rhythm control may reverse it.",
            "Screen and treat OSA in recurrent AF \u2013 markedly reduces recurrence.",
            "AF with WPW \u2013 AVOID AV-nodal blockers.",
        ),
        qna = listOf(
            QnA(
                "80-year-old woman, AF, HTN, CHA\u2082DS\u2082-VASc 4, HAS-BLED 3 \u2013 anticoagulate?",
                "Yes. A high HAS-BLED score is not a contraindication; it prompts modification of bleeding risk factors (BP control, stop NSAIDs).",
            ),
            QnA(
                "AF with mitral stenosis \u2013 DOAC or warfarin?",
                "Warfarin with INR 2\u20133. DOACs are contraindicated in moderate-to-severe (rheumatic) mitral stenosis and in mechanical valves.",
            ),
            QnA(
                "Young patient, first episode AF, onset < 12 h, haemodynamically stable \u2013 management?",
                "If low embolic risk and onset clearly < 48 h: pharmacological or electrical cardioversion is reasonable; otherwise anticoagulate \u2265 3 weeks then cardiovert (or TOE-guided).",
            ),
            QnA(
                "Which antiarrhythmic is safest if structural or ischaemic heart disease?",
                "Amiodarone (followed by dofetilide or sotalol in selected patients). Flecainide and propafenone are contraindicated.",
            ),
            QnA(
                "Post-ablation recurrence of AF at 2 months \u2013 significance?",
                "Early recurrences in the 3-month blanking period are common and do not constitute failure; reassess beyond 3 months.",
            ),
        ),
    )

    private val hypertension = Topic(
        id = "card-htn",
        title = "Hypertension",
        subtitle = "Diagnosis, targets and pharmacotherapy",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 277 \u2013 Hypertensive vascular disease"),
            TopicReference("Davidson 24e", "Ch. 16 \u2013 Cardiovascular disease (Hypertension section)"),
        ),
        sections = listOf(
            TopicSection(
                "Diagnosis",
                listOf(
                    Paragraph(
                        "Do not diagnose hypertension on a single clinic reading. Confirm with ambulatory (ABPM) or home blood-pressure monitoring (HBPM). Always check for end-organ damage at diagnosis (fundoscopy, ECG / LVH, urinalysis / ACR, U&E, HbA1c, lipids)."
                    ),
                    Table(
                        title = "Thresholds (NICE / ESH)",
                        headers = listOf("Category", "Clinic BP (mmHg)", "Ambulatory / home (mmHg)"),
                        rows = listOf(
                            listOf("Stage 1", "140\u2013159 / 90\u201399", "\u2265 135 / 85"),
                            listOf("Stage 2", "160\u2013179 / 100\u2013109", "\u2265 150 / 95"),
                            listOf("Stage 3 / severe", "\u2265 180 / 110", "\u2013"),
                        ),
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "Think about secondary hypertension in: young patient (< 40) with stage 2 BP, resistant hypertension (uncontrolled on \u2265 3 drugs including a diuretic), hypokalaemia, abdominal bruit, phenotypic clues (Cushingoid, thyroid signs), sudden worsening BP, or hypertension with prominent end-organ damage."
                    ),
                ),
            ),
            TopicSection(
                "Secondary causes \u2013 what to screen and how",
                listOf(
                    Table(
                        title = "Common secondary causes",
                        headers = listOf("Cause", "Key clue", "Initial test"),
                        rows = listOf(
                            listOf("Primary hyperaldosteronism", "Hypokalaemia; resistant HTN", "Plasma aldosterone : renin ratio"),
                            listOf("Renovascular disease", "Abdominal bruit; rise in creatinine with ACE-I", "Renal artery duplex / CT/MR angiography"),
                            listOf("Renal parenchymal disease", "Proteinuria, eGFR\u2193", "U&E, urinalysis, ACR, renal US"),
                            listOf("Phaeochromocytoma", "Episodic headache, sweating, palpitations", "24-h urinary metanephrines"),
                            listOf("Cushing syndrome", "Central obesity, striae, easy bruising", "Overnight dexamethasone / 24-h urinary cortisol"),
                            listOf("Obstructive sleep apnoea", "Snoring, daytime sleepiness, obesity", "Overnight polysomnography"),
                            listOf("Coarctation of aorta", "Radio-femoral delay; rib notching", "Echocardiography; CT/MR aorta"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Lifestyle \u2013 foundational"),
                    Bullets(
                        listOf(
                            "DASH-style diet; salt < 5 g/day; alcohol \u2264 14 U/week; weight reduction; aerobic exercise 30 min on most days; smoking cessation.",
                            "Treat co-morbid OSA, CKD and diabetes aggressively.",
                        )
                    ),
                    SubHeading("Pharmacotherapy \u2013 stepped care"),
                    Numbered(
                        listOf(
                            "Step 1: ACE-inhibitor or ARB if < 55 years and not of African / Caribbean family origin; calcium-channel blocker (CCB) if \u2265 55 or African/Caribbean origin.",
                            "Step 2: combine ACE-I/ARB with CCB or with a thiazide-like diuretic (indapamide, chlortalidone).",
                            "Step 3: triple therapy with ACE-I/ARB + CCB + thiazide-like diuretic.",
                            "Step 4 (resistant HTN): add spironolactone if K\u207a \u2264 4.5 mmol/L (confirm adherence and screen for secondary causes first); otherwise an alpha- or beta-blocker.",
                        )
                    ),
                    SubHeading("Targets"),
                    Bullets(
                        listOf(
                            "General: < 140 / 90 mmHg clinic; intensify to < 130 / 80 if tolerated (ACC/AHA).",
                            "Diabetes with CV risk: < 130 / 80.",
                            "CKD with ACR \u2265 70 mg/mmol (proteinuric): < 130 / 80.",
                            "\u2265 80 years: < 150 / 90 acceptable; individualise based on frailty.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Hypertensive emergency vs urgency",
                listOf(
                    Paragraph(
                        "\u201cEmergency\u201d = severe hypertension with acute end-organ injury (encephalopathy, retinal haemorrhage/papilloedema, acute LV failure, aortic dissection, MI, AKI, pre-eclampsia). \u201cUrgency\u201d = severe hypertension without acute end-organ damage."
                    ),
                    Bullets(
                        listOf(
                            "Emergency management \u2013 admit; intravenous therapy to reduce mean arterial pressure by \u2264 25 % in the first hour, then toward 160/100 over 2\u20136 h, then normalise over 24\u201348 h.",
                            "Drug choice is tailored: nitroprusside/labetalol for encephalopathy; esmolol + nitroprusside (or clevidipine) for aortic dissection (target SBP 100\u2013120, HR < 60); hydralazine/labetalol + magnesium for pre-eclampsia.",
                            "Urgency \u2013 oral agents and close follow-up; rapid BP lowering can provoke ischaemia.",
                        )
                    ),
                    Callout(CalloutKind.Warning, "Do not drop BP too rapidly in hypertensive encephalopathy or acute stroke \u2013 autoregulation is shifted rightward; over-correction causes watershed ischaemia."),
                ),
            ),
        ),
        boardPearls = listOf(
            "Confirm a hypertension diagnosis with ABPM/HBPM, not isolated clinic readings.",
            "Always check end-organ damage at diagnosis: fundi, ECG (LVH), ACR, U&E, HbA1c.",
            "Screen for secondary causes in the young, the resistant, the hypokalaemic, and the suddenly-worsening.",
            "Primary aldosteronism is the most common reversible secondary cause; check ARR off interfering drugs where possible.",
            "ACE-I/ARB first-line in diabetes, CKD with proteinuria, and post-MI.",
            "Spironolactone is the key step-4 drug in resistant hypertension if K\u207a \u2264 4.5.",
            "In aortic dissection target HR < 60 first with IV beta-blocker, then lower BP \u2013 do not drop BP without controlling rate (risk of reflex tachycardia and propagation).",
            "Hypertensive emergency \u2013 reduce MAP by \u2264 25 % in the first hour.",
            "Pre-eclampsia \u2013 labetalol, methyldopa or nifedipine; avoid ACE-I/ARB (teratogenic).",
            "Isolated systolic hypertension in the elderly is still a strong CV risk factor and should be treated.",
        ),
        qna = listOf(
            QnA(
                "Resistant hypertension on ACE-I + amlodipine + indapamide, K\u207a 4.1 \u2013 next drug?",
                "Spironolactone (12.5\u201325 mg daily) \u2013 PATHWAY-2 trial.",
            ),
            QnA(
                "30-year-old with stage 2 hypertension and K\u207a 3.1 \u2013 next investigation?",
                "Aldosterone:renin ratio (screen for primary hyperaldosteronism).",
            ),
            QnA(
                "BP 220/130 with blurred vision and papilloedema \u2013 disposition?",
                "Hypertensive emergency \u2013 admit for IV therapy; aim MAP reduction \u2264 25 % in first hour.",
            ),
            QnA(
                "Preferred antihypertensive in pregnancy?",
                "Labetalol (first-line), methyldopa, or nifedipine. ACE-I/ARB/MRA/DRI are contraindicated.",
            ),
            QnA(
                "Patient with chronic kidney disease (eGFR 30) and ACR 80 mg/mmol \u2013 BP target and first-line drug?",
                "< 130/80; ACE-I or ARB as first-line (reduces proteinuria and slows progression).",
            ),
        ),
    )

    private val endocarditis = Topic(
        id = "card-ie",
        title = "Infective Endocarditis",
        subtitle = "Diagnosis, microbiology and management",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 128 \u2013 Infective endocarditis"),
            TopicReference("Davidson 24e", "Ch. 16 \u2013 Cardiovascular disease (Endocarditis section)"),
        ),
        sections = listOf(
            TopicSection(
                "Pathogenesis & risk factors",
                listOf(
                    Paragraph(
                        "Infective endocarditis (IE) is microbial infection of the endocardial surface, most often involving a heart valve. " +
                            "Turbulent flow damages the endocardium, leading to a platelet-fibrin thrombus (non-bacterial thrombotic endocarditis) that is later colonised during transient bacteraemia."
                    ),
                    Bullets(
                        listOf(
                            "Prosthetic valves \u2013 highest single risk (up to 1 %/year).",
                            "Previous IE.",
                            "Unrepaired cyanotic congenital heart disease.",
                            "Rheumatic / degenerative valve disease.",
                            "Intravenous drug use \u2013 right-sided involvement, most commonly tricuspid.",
                            "Indwelling intravascular devices, chronic haemodialysis.",
                            "Recent dental, genitourinary or gastrointestinal procedures in susceptible patients.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Microbiology",
                listOf(
                    Table(
                        title = "Common causative organisms",
                        headers = listOf("Clinical context", "Typical organisms"),
                        rows = listOf(
                            listOf("Native valve, community-acquired", "Staph. aureus, viridans streptococci, enterococci"),
                            listOf("Early prosthetic valve (< 1 year)", "Staph. aureus, coagulase-negative staphylococci, Gram negatives, fungi"),
                            listOf("Late prosthetic valve (> 1 year)", "Similar to native valve: staphylococci, streptococci, enterococci"),
                            listOf("IV drug use (right-sided)", "Staph. aureus (often MRSA), Pseudomonas, Candida"),
                            listOf("Healthcare-associated", "Staph. aureus, coagulase-negative staphylococci, enterococci"),
                            listOf("Culture-negative", "HACEK, Coxiella burnetii, Bartonella, Brucella, Tropheryma whipplei"),
                            listOf("Colonic disease", "Streptococcus gallolyticus (bovis) \u2013 prompts colonoscopy"),
                        ),
                    ),
                    Callout(CalloutKind.Exam, "S. gallolyticus (bovis) bacteraemia or IE mandates colonoscopy \u2013 strong association with colorectal neoplasia."),
                ),
            ),
            TopicSection(
                "Clinical features",
                listOf(
                    Bullets(
                        listOf(
                            "Fever (> 90 %), malaise, weight loss, night sweats.",
                            "New or changing regurgitant murmur.",
                            "Embolic phenomena: stroke, splenic / renal / pulmonary infarction, septic pulmonary emboli (right-sided IE).",
                            "Immunological / vascular signs: Osler nodes (tender, pulp of fingers), Janeway lesions (non-tender, palms/soles), Roth spots, splinter haemorrhages, glomerulonephritis, positive rheumatoid factor.",
                            "Signs of heart failure from valvular destruction \u2013 a poor prognostic feature.",
                        )
                    ),
                    Callout(CalloutKind.Pitfall, "In right-sided IE, the murmur may be quiet and systemic embolic signs are absent; instead look for septic pulmonary emboli on CXR/CT."),
                ),
            ),
            TopicSection(
                "Diagnosis \u2013 modified Duke criteria",
                listOf(
                    Paragraph(
                        "Definite IE: 2 major, OR 1 major + 3 minor, OR 5 minor. Possible IE: 1 major + 1 minor, OR 3 minor."
                    ),
                    Table(
                        title = "Modified Duke criteria",
                        headers = listOf("Category", "Criteria"),
                        rows = listOf(
                            listOf(
                                "Major",
                                "(a) Typical organism from 2 separate blood cultures (S. viridans, S. gallolyticus, HACEK, S. aureus, community-acquired enterococci with no primary focus); " +
                                    "(b) persistently positive blood cultures; (c) single positive for C. burnetii or phase I IgG > 1:800; " +
                                    "(d) echocardiographic evidence (vegetation, abscess, new partial dehiscence of prosthetic valve); (e) new valvular regurgitation."
                            ),
                            listOf(
                                "Minor",
                                "Predisposing heart condition or IVDU; fever \u2265 38 \u00b0C; vascular phenomena; immunologic phenomena; microbiological evidence not meeting major; echocardiographic findings not meeting major."
                            ),
                        ),
                    ),
                    Bullets(
                        listOf(
                            "Obtain at least three sets of blood cultures from separate venepunctures over 1 h before antibiotics.",
                            "Transthoracic echo first; transoesophageal echo if negative but clinical suspicion remains, or for prosthetic valves.",
                            "Consider cardiac CT, PET-CT (especially prosthetic valves / device infection), and MRI brain in selected cases.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Empirical antibiotics \u2013 start after cultures, tailor to sensitivities"),
                    Table(
                        title = null,
                        headers = listOf("Setting", "Typical empirical regimen"),
                        rows = listOf(
                            listOf(
                                "Native valve / late prosthetic, community-acquired",
                                "Amoxicillin + gentamicin (or vancomycin + gentamicin if penicillin allergic / MRSA risk)"
                            ),
                            listOf(
                                "Early prosthetic valve / healthcare-associated / IVDU",
                                "Vancomycin + gentamicin + rifampicin (rifampicin if prosthetic material)"
                            ),
                            listOf(
                                "Culture-negative after 48 h",
                                "Broaden to cover HACEK, Coxiella, Bartonella, Brucella \u2013 add ceftriaxone \u00b1 doxycycline; targeted serology and PCR"
                            ),
                        ),
                    ),
                    Paragraph(
                        "Typical duration 4\u20136 weeks of bactericidal intravenous therapy; outpatient parenteral antibiotic therapy (OPAT) is feasible after initial in-hospital stabilisation and with stable microbiology / imaging."
                    ),
                    SubHeading("Surgical indications"),
                    Bullets(
                        listOf(
                            "Heart failure from valvular regurgitation \u2013 the strongest indication.",
                            "Uncontrolled infection: abscess, fistula, enlarging vegetation despite appropriate antibiotics.",
                            "Prevention of embolism: persistent large vegetation > 10 mm with prior embolism, or > 15 mm with mobile characteristics.",
                            "Prosthetic valve IE with S. aureus, fungal infection, or early dehiscence.",
                            "Fungal endocarditis \u2013 surgery plus prolonged antifungal therapy.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Prophylaxis",
                listOf(
                    Bullets(
                        listOf(
                            "Only the highest-risk groups receive antibiotic prophylaxis for specified procedures (ESC 2023, NICE): prosthetic valve, prior IE, congenital heart disease (cyanotic or repaired with residual defect / prosthetic material).",
                            "Eligible procedures: dental procedures involving manipulation of the gingiva or periapical region, or perforation of the oral mucosa.",
                            "Recommended regimen: amoxicillin 2 g PO 30\u201360 min before the procedure (clindamycin 600 mg if penicillin-allergic; note the US/UK are moving away from clindamycin toward azithromycin/cephalexin due to C. difficile risk).",
                            "Emphasise daily oral hygiene and regular dental review \u2013 more effective than antibiotic prophylaxis at reducing IE.",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Three separate blood culture sets BEFORE antibiotics \u2013 do not wait to treat, but do culture first.",
            "TOE is the imaging of choice for prosthetic valves and when TTE is negative but suspicion remains.",
            "S. aureus bacteraemia from any source without a clear focus mandates echocardiography.",
            "S. gallolyticus (bovis) bacteraemia \u2192 colonoscopy.",
            "HACEK organisms (Haemophilus, Aggregatibacter, Cardiobacterium, Eikenella, Kingella) need \u2265 5-day cultures \u2013 warn the microbiology lab.",
            "Heart failure from valvular destruction is the top indication for surgery and cannot be \u2018treated\u2019 with more antibiotics.",
            "In IVDU-associated right-sided tricuspid IE, isolated right-sided disease from S. aureus often responds to medical therapy alone.",
            "Rifampicin is only useful once adherent bacteria are present \u2013 reserve for prosthetic material and add to the regimen after 3\u20135 days.",
            "Culture-negative IE \u2013 remember Coxiella (Q fever), Bartonella, Brucella; also libman-Sacks (SLE) and marantic (malignancy) as non-infective mimics.",
            "Routine antibiotic prophylaxis is not indicated for colonoscopy, cystoscopy or childbirth, even in high-risk patients.",
        ),
        qna = listOf(
            QnA(
                "Diabetic man with fever, new mitral regurgitation murmur, TTE shows 8 mm vegetation \u2013 next step?",
                "Three sets of blood cultures from separate sites, then empirical vancomycin + gentamicin (native valve, pending sensitivities). TOE to define vegetation size and rule out abscess.",
            ),
            QnA(
                "Which organism is most strongly associated with colorectal cancer?",
                "Streptococcus gallolyticus (bovis) \u2013 colonoscopy mandatory after bacteraemia or IE.",
            ),
            QnA(
                "Patient with recent dental procedure, now IE with viridans streptococci and severe aortic regurgitation + pulmonary oedema \u2013 indication for surgery?",
                "Yes \u2013 heart failure from valvular regurgitation is the strongest indication, regardless of antibiotic response.",
            ),
            QnA(
                "IVDU with fever, bilateral cavitating pulmonary lesions and TR murmur \u2013 likely diagnosis and organism?",
                "Right-sided (tricuspid) IE; Staph. aureus is the most likely pathogen. Empirical vancomycin pending sensitivities.",
            ),
            QnA(
                "Who receives dental IE prophylaxis?",
                "Patients with prosthetic valves, prior IE, or cyanotic / incompletely repaired congenital heart disease \u2013 for procedures involving manipulation of the gingiva/periapical region, or oral-mucosa perforation.",
            ),
        ),
    )

    // Topic stubs are placeholders until full content is written.
    private fun stub(id: String, title: String, subtitle: String = "") = Topic(
        id = id,
        title = title,
        subtitle = subtitle,
    )

    val all: List<Topic> = listOf(
        acs,
        heartFailure,
        af,
        hypertension,
        endocarditis,
    )
}
