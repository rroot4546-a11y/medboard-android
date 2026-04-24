package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object CardiologyTopicsPart2 {

    private val stableIhd = Topic(
        id = "card-stable-ihd",
        title = "Stable Coronary Artery Disease",
        subtitle = "Chronic coronary syndrome (CCS)",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 267 \u2014 Ischaemic heart disease"),
            TopicReference("Davidson 24e", "Ch. 16 \u2014 Cardiovascular disease (Stable angina)"),
        ),
        sections = listOf(
            TopicSection(
                "Overview",
                listOf(
                    Paragraph(
                        "Chronic coronary syndrome (CCS) describes the spectrum of patients with stable, usually exertional, symptoms or asymptomatic atherosclerotic CAD. It is now understood as a progressive process punctuated by unstable events, rather than a static \u201cstable\u201d disease."
                    ),
                    Bullets(
                        listOf(
                            "Typical angina: retrosternal chest discomfort, provoked by exertion/emotion, relieved by rest or GTN within minutes.",
                            "Atypical angina: two of the three typical features.",
                            "Non-anginal chest pain: one or none of the above.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Diagnostic workup",
                listOf(
                    SubHeading("Pre-test probability and non-invasive testing"),
                    Paragraph(
                        "Use clinical probability (age, sex, symptoms, risk factors) to choose the next test. Intermediate-probability patients benefit most from non-invasive imaging; very low or very high probability patients may not need additional testing before empirical management or angiography.",
                        source = TopicSource.Harrison,
                    ),
                    Table(
                        title = "Non-invasive tests",
                        headers = listOf("Test", "Best used when", "Key limitation"),
                        rows = listOf(
                            listOf("Coronary CT angiography", "Low-to-intermediate probability; rule out CAD", "Heavy calcification/renal impairment"),
                            listOf("Stress echocardiography", "Assess ischaemia & LV function", "Operator-dependent"),
                            listOf("Stress cardiac MRI", "Quantitative perfusion; viability", "Availability"),
                            listOf("SPECT / PET myocardial perfusion", "Ischaemic burden", "Radiation"),
                            listOf("Exercise ECG", "When imaging unavailable", "Low sensitivity/specificity"),
                        ),
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "CT coronary angiography has become the first-line test to rule out CAD in low-to-intermediate risk; a stress/ischaemia test is preferred when the question is \u2018does this patient have inducible ischaemia?\u2019",
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Lifestyle & risk-factor modification"),
                    Bullets(
                        listOf(
                            "Smoking cessation (single biggest gain).",
                            "Mediterranean-style diet; regular aerobic activity; weight target.",
                            "BP target < 130/80 in most; individualise if frail or elderly.",
                            "LDL-C target < 1.4 mmol/L (< 55 mg/dL) with \u2265 50 % reduction \u2014 high-intensity statin \u00b1 ezetimibe \u00b1 PCSK9 inhibitor.",
                            "HbA1c ~53 mmol/mol (7.0 %) for most; consider lower if young, without hypoglycaemia.",
                        ),
                        source = TopicSource.Both,
                    ),
                    SubHeading("Antianginal therapy"),
                    Numbered(
                        listOf(
                            "Beta-blocker or calcium-channel blocker first line \u2014 choose based on HR, BP, LV function and comorbidities.",
                            "Add long-acting nitrate, ivabradine, ranolazine or nicorandil if symptoms persist.",
                            "Short-acting sublingual GTN for breakthrough episodes \u2014 instruct on correct use and when to seek help.",
                        )
                    ),
                    SubHeading("Antiplatelets & secondary prevention"),
                    Bullets(
                        listOf(
                            "Aspirin 75\u2013100 mg daily lifelong (clopidogrel 75 mg as alternative).",
                            "High-intensity statin regardless of baseline LDL.",
                            "ACE-inhibitor (or ARB) if hypertension, diabetes, CKD or LV dysfunction.",
                            "Influenza & pneumococcal vaccination reduce CV events.",
                        )
                    ),
                    SubHeading("Revascularisation"),
                    Bullets(
                        listOf(
                            "Indicated for symptoms refractory to optimal medical therapy, or for prognostic benefit (left main, 3-vessel CAD especially with diabetes or reduced LV function).",
                            "PCI vs CABG: CABG preferred for complex multivessel disease with diabetes and for left-main with high SYNTAX score.",
                            "ISCHEMIA trial: routine revascularisation did not reduce death/MI in stable CAD beyond optimal medical therapy \u2014 but improved angina.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "LDL target in established CAD is < 1.4 mmol/L (< 55 mg/dL) with \u2265 50 % reduction.",
            "Aspirin + high-intensity statin + ACE-I (if indicated) is the minimum secondary-prevention package.",
            "CT coronary angiography is first-line to rule out CAD in low-to-intermediate risk.",
            "PCI improves symptoms but not mortality in stable CAD (ISCHEMIA).",
            "CABG beats PCI in diabetic multivessel disease (FREEDOM).",
            "Ranolazine is useful in chronic angina with preserved EF; monitor QT.",
            "Ivabradine only works in sinus rhythm with HR \u2265 70 bpm.",
            "Continue antianginals pre- and post-revascularisation unless contraindicated.",
        ),
        qna = listOf(
            QnA(
                "Stable angina on maximal beta-blocker and long-acting nitrate with persistent symptoms and HR 78 in sinus rhythm \u2014 next step?",
                "Add ivabradine (or a dihydropyridine CCB) \u2014 ivabradine requires sinus rhythm and HR \u2265 70 bpm.",
            ),
            QnA(
                "Diabetic patient with 3-vessel CAD and LVEF 45 % \u2014 PCI or CABG?",
                "CABG is superior in diabetic multivessel CAD (FREEDOM trial).",
            ),
            QnA(
                "Patient on optimal medical therapy for CCS still has angina \u2014 does revascularisation reduce mortality?",
                "No in stable CAD (ISCHEMIA), but it reduces angina. Prognostic benefit is seen in left-main or proximal 3-vessel disease with reduced LV function.",
            ),
        ),
    )

    private val valvular = Topic(
        id = "card-valvular",
        title = "Valvular Heart Disease",
        subtitle = "AS, AR, MS, MR",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 261\u2013264 \u2014 Valvular heart disease"),
            TopicReference("Davidson 24e", "Ch. 16 \u2014 Cardiovascular disease (Valvular heart disease)"),
        ),
        sections = listOf(
            TopicSection(
                "Aortic stenosis (AS)",
                listOf(
                    Paragraph(
                        "Aortic stenosis in adults is most often due to calcific (age-related) degeneration of a normal tricuspid valve or earlier calcification of a congenitally bicuspid valve. Rheumatic AS is now rare in high-income settings."
                    ),
                    SubHeading("Clinical features"),
                    Bullets(
                        listOf(
                            "Classic triad: exertional dyspnoea, angina and syncope \u2014 each heralds a step-down in prognosis.",
                            "Slow-rising, low-volume pulse; narrow pulse pressure.",
                            "Ejection-systolic murmur loudest at right upper sternal edge, radiating to carotids; soft A2 as disease progresses; reversed split S2; fourth heart sound.",
                        )
                    ),
                    SubHeading("Severe AS \u2014 echo criteria"),
                    Table(
                        title = null,
                        headers = listOf("Parameter", "Severe"),
                        rows = listOf(
                            listOf("Aortic valve area", "\u2264 1.0 cm\u00b2"),
                            listOf("Peak jet velocity", "\u2265 4 m/s"),
                            listOf("Mean gradient", "\u2265 40 mmHg"),
                            listOf("Dimensionless index", "\u2264 0.25"),
                        ),
                    ),
                    SubHeading("Management"),
                    Bullets(
                        listOf(
                            "Definitive therapy is valve replacement \u2014 surgical AVR or TAVI depending on surgical risk, anatomy, age and patient preference.",
                            "Intermediate, high or prohibitive surgical risk \u2014 TAVI preferred (PARTNER, SURTAVI, Evolut Low-Risk).",
                            "Avoid aggressive vasodilators (preload-dependent); cautious diuretics for symptomatic congestion.",
                            "Secondary statin and antihypertensives as per atherosclerotic risk \u2014 statins do not slow AS progression.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Symptom onset in severe AS (angina, syncope, HF) mandates early valve replacement \u2014 untreated mean survival is 2\u20135 years.",
                    ),
                ),
            ),
            TopicSection(
                "Aortic regurgitation (AR)",
                listOf(
                    Bullets(
                        listOf(
                            "Chronic AR: bicuspid valve, rheumatic, calcific, aortic root dilatation (HTN, Marfan, EDS, syphilis).",
                            "Acute AR: IE, aortic dissection, trauma \u2014 cardiogenic shock, pulmonary oedema with a soft or absent murmur.",
                            "Signs: collapsing pulse, wide pulse pressure; early diastolic murmur at LSE; Austin-Flint murmur (mid-diastolic at apex); de Musset, Corrigan, Quincke, Traube, Duroziez signs.",
                        )
                    ),
                    SubHeading("Indications for surgery"),
                    Numbered(
                        listOf(
                            "Symptomatic severe AR.",
                            "Asymptomatic severe AR with LVEF \u2264 50 % or LV end-systolic dimension > 50 mm (or 25 mm/m\u00b2).",
                            "Severe AR undergoing other cardiac surgery.",
                            "Any severe acute AR \u2014 emergency surgery.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Mitral stenosis (MS)",
                listOf(
                    Paragraph(
                        "Almost always rheumatic. Presents with exertional dyspnoea, haemoptysis, AF, and systemic embolism. Examination: loud S1, opening snap, low-pitched mid-diastolic murmur at apex (best heard in the left lateral position with the bell)."
                    ),
                    SubHeading("Severity & management"),
                    Bullets(
                        listOf(
                            "Severe MS: mitral valve area \u2264 1.5 cm\u00b2; symptoms often begin below 1.0 cm\u00b2.",
                            "Rate control for AF \u2014 beta-blocker, diltiazem or digoxin.",
                            "Anticoagulation (warfarin \u2014 DOACs contraindicated in moderate-to-severe rheumatic MS) if AF, prior embolism, or large LA/thrombus.",
                            "Percutaneous mitral balloon commissurotomy for favourable valve anatomy without significant MR/thrombus.",
                            "Mitral valve replacement for unfavourable anatomy, severe MR or restenosis.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Mitral regurgitation (MR)",
                listOf(
                    SubHeading("Primary vs secondary MR"),
                    Bullets(
                        listOf(
                            "Primary (organic): degenerative (mitral valve prolapse most common in developed world), rheumatic, IE, papillary muscle rupture.",
                            "Secondary (functional): LV dilatation/dysfunction causing leaflet tethering and annular dilatation \u2014 part of the heart-failure syndrome.",
                        )
                    ),
                    SubHeading("Clinical features & management"),
                    Bullets(
                        listOf(
                            "Apical pan-systolic murmur radiating to axilla; displaced apex; loud P2 in pulmonary hypertension.",
                            "Severe primary MR: intervention when symptomatic, or asymptomatic with LV dilatation (LVESD \u2265 40 mm) or EF < 60 %, new AF or pulmonary hypertension.",
                            "Degenerative MR: valve repair preferred over replacement; MitraClip for selected non-surgical candidates.",
                            "Secondary MR: optimise guideline-directed HF therapy first; transcatheter edge-to-edge repair (COAPT) in selected patients who remain symptomatic.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Exam,
                        "Acute severe MR after inferior MI \u2014 think papillary muscle rupture (posteromedial PM has single-vessel supply from PDA). Urgent echo and surgery.",
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "AS triad (angina, syncope, dyspnoea) heralds a step-down in prognosis \u2014 valve replacement, don\u2019t delay.",
            "TAVI is now first-line for severe AS in intermediate-to-high surgical risk and a strong option for low-risk elderly.",
            "Acute severe AR (dissection, IE) needs emergency surgery \u2014 medical therapy is a bridge.",
            "Mitral stenosis with AF requires warfarin, not DOACs.",
            "Percutaneous mitral balloon valvotomy in MS: good for pliable, non-calcified valve without MR or LA thrombus.",
            "Primary severe MR with LVEF 55\u201360 % and LVESD \u2265 40 mm \u2192 early repair improves outcomes.",
            "COAPT trial: transcatheter edge-to-edge repair helps selected secondary MR (moderate-to-severe, LVEF 20\u201350 %) after optimal HF therapy.",
            "Austin-Flint murmur (mid-diastolic) is a mimic of MS but occurs in AR.",
        ),
        qna = listOf(
            QnA(
                "70-year-old with severe AS, exertional syncope, STS score 5 %. What is the preferred intervention?",
                "TAVI is reasonable at this age and intermediate surgical risk; surgical AVR also acceptable \u2014 multidisciplinary heart team decision.",
            ),
            QnA(
                "Asymptomatic severe AR, LVEF 48 %, LVESD 47 mm \u2014 surgery?",
                "Yes \u2014 LV end-systolic dimension > 50 mm or LVEF \u2264 50 % is an indication for AVR.",
            ),
            QnA(
                "Rheumatic MS, AF, moderate-severe MS \u2014 anticoagulant choice?",
                "Warfarin with INR 2\u20133; DOACs are contraindicated.",
            ),
            QnA(
                "Severe secondary MR, LVEF 35 %, NYHA III on optimal HF therapy \u2014 next step?",
                "Consider transcatheter edge-to-edge repair (MitraClip) \u2014 COAPT trial benefit in carefully-selected patients.",
            ),
        ),
    )

    private val cardiomyopathies = Topic(
        id = "card-cardiomyopathy",
        title = "Cardiomyopathies",
        subtitle = "DCM, HCM, RCM, ARVC",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 259 \u2014 Cardiomyopathy and myocarditis"),
            TopicReference("Davidson 24e", "Ch. 16 \u2014 Cardiovascular disease (Cardiomyopathies)"),
        ),
        sections = listOf(
            TopicSection(
                "Dilated cardiomyopathy (DCM)",
                listOf(
                    Bullets(
                        listOf(
                            "Dilated LV with systolic dysfunction and no primary ischaemic, valvular, hypertensive or congenital cause.",
                            "Common causes: familial (~30 %, truncating TTN variants), alcohol, chemotherapy (anthracyclines, trastuzumab), peripartum, viral myocarditis, tachycardia-induced, thiamine deficiency, haemochromatosis, HIV.",
                            "Management: standard HFrEF four pillars (ARNI/ACE-I, beta-blocker, MRA, SGLT2 inhibitor); ICD for primary prevention when EF \u2264 35 % on OMT; CRT if LBBB with QRS \u2265 130 ms.",
                            "Peripartum cardiomyopathy: up to 1 month before to 5 months after delivery; bromocriptine adjunct considered; avoid ACE-I/ARB while pregnant.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Hypertrophic cardiomyopathy (HCM)",
                listOf(
                    Paragraph(
                        "Autosomal-dominant sarcomeric gene disorders (most commonly MYH7, MYBPC3). Asymmetric septal hypertrophy with dynamic LV outflow tract obstruction; diastolic dysfunction and myocyte disarray are key features."
                    ),
                    SubHeading("Clinical features"),
                    Bullets(
                        listOf(
                            "Dyspnoea, angina, syncope, palpitations; many are asymptomatic.",
                            "Harsh ejection-systolic murmur that increases with Valsalva and standing, decreases with squatting and handgrip.",
                            "ECG: LVH, deep T-wave inversions (especially apical HCM \u2014 \u201cYamaguchi\u201d), pseudo-infarct Q waves.",
                            "Echo: septum \u2265 15 mm (or \u2265 13 mm with family history), SAM of mitral valve, dynamic LVOT gradient \u2265 30 mmHg at rest or with provocation defines obstructive HCM.",
                        ),
                    ),
                    SubHeading("Management"),
                    Bullets(
                        listOf(
                            "Beta-blocker first line; add disopyramide or verapamil (if LVOT obstruction, start verapamil cautiously).",
                            "Avoid dehydration, vigorous exertion, and pure vasodilators (nitrates, ACE-I) in obstructive HCM.",
                            "Mavacamten (cardiac myosin inhibitor) \u2014 reduces obstruction and improves symptoms in obstructive HCM (EXPLORER-HCM).",
                            "Invasive septal reduction (myectomy or alcohol septal ablation) for refractory symptoms.",
                            "Implantable defibrillator for sudden-death prevention in high-risk patients \u2014 risk calculated from the HCM Risk-SCD score (septal thickness \u2265 30 mm, family history of SCD, unexplained syncope, non-sustained VT, abnormal BP response to exercise, LA diameter, LVOT gradient, age).",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Sudden cardiac death in young athletes is classically due to HCM \u2014 screen family members and avoid competitive sports if obstructive HCM or high-risk features.",
                    ),
                ),
            ),
            TopicSection(
                "Restrictive cardiomyopathy (RCM) & ARVC",
                listOf(
                    SubHeading("Restrictive"),
                    Bullets(
                        listOf(
                            "Non-dilated, non-hypertrophied ventricles with stiff walls \u2014 predominant diastolic dysfunction.",
                            "Causes: amyloidosis (ATTR, AL), sarcoidosis, haemochromatosis, endomyocardial fibrosis, post-radiation.",
                            "Cardiac amyloid: low-voltage ECG with LVH on echo, carpal tunnel history, autonomic features. Tc-99m pyrophosphate scan for ATTR; tafamidis disease-modifying.",
                            "Distinguish from constrictive pericarditis: MRI/CT shows pericardial thickening; discordant respiratory variation in constriction but not RCM.",
                        ),
                    ),
                    SubHeading("Arrhythmogenic right ventricular cardiomyopathy (ARVC)"),
                    Bullets(
                        listOf(
                            "Fibrofatty replacement of the RV myocardium; desmosomal gene mutations.",
                            "VT with LBBB morphology (RV origin); epsilon wave and T-inversion V1\u2013V3 on ECG.",
                            "Management: avoid endurance sport, beta-blocker, ICD in high-risk features (syncope, sustained VT, severe RV dysfunction).",
                        ),
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "HCM murmur \u2191 with Valsalva/standing; \u2193 with squat/handgrip \u2014 opposite of most murmurs.",
            "Avoid nitrates, ACE-I, diuretics (if possible) in obstructive HCM \u2014 worsens outflow obstruction.",
            "Mavacamten is a myosin inhibitor newly approved for obstructive HCM.",
            "Family screening in HCM: first-degree relatives should have echo and ECG every 3\u20135 years (annually through adolescence).",
            "Restrictive vs constrictive: pericardial thickening on imaging, septal bounce, Kussmaul sign in constriction; respiratory discordance.",
            "Peripartum cardiomyopathy: many recover; avoid subsequent pregnancy if LV function has not normalised.",
            "ARVC \u2014 think in young athlete with VT of LBBB morphology and syncope.",
            "Cardiac amyloid with HFpEF + carpal tunnel \u2192 PYP scan, not biopsy first.",
        ),
        qna = listOf(
            QnA(
                "Young athlete collapses during exercise; echo shows asymmetric septal thickness 20 mm \u2014 diagnosis and lifestyle?",
                "Hypertrophic cardiomyopathy; avoid competitive sports and perform family screening; assess SCD risk.",
            ),
            QnA(
                "HCM patient on beta-blocker still symptomatic with resting LVOT gradient 70 mmHg \u2014 next step?",
                "Add disopyramide, then consider mavacamten or invasive septal reduction (myectomy or alcohol ablation).",
            ),
            QnA(
                "Elderly man, HFpEF, low-voltage ECG with LVH, bilateral carpal tunnel history \u2014 next diagnostic step?",
                "Tc-99m pyrophosphate (PYP) scintigraphy \u2014 strongly positive in ATTR cardiac amyloid, sparing biopsy in most cases.",
            ),
        ),
    )

    private val pericardial = Topic(
        id = "card-pericardial",
        title = "Pericardial Disease",
        subtitle = "Pericarditis, tamponade, constriction",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 265 \u2014 Pericardial disease"),
            TopicReference("Davidson 24e", "Ch. 16 \u2014 Cardiovascular disease (Pericardial disease)"),
        ),
        sections = listOf(
            TopicSection(
                "Acute pericarditis",
                listOf(
                    Paragraph(
                        "Acute pericarditis is typically idiopathic or viral (Coxsackie, echo, adenovirus). Other causes include autoimmune disease, uraemia, malignancy, TB, post-MI (early) and Dressler syndrome (autoimmune pericarditis 2\u20136 weeks post-MI)."
                    ),
                    SubHeading("Diagnosis (\u2265 2 of 4)"),
                    Bullets(
                        listOf(
                            "Typical pleuritic chest pain, sharp, relieved leaning forward.",
                            "Pericardial friction rub.",
                            "ECG: diffuse concave ST-elevation with PR depression; later T-wave inversion.",
                            "New or worsening pericardial effusion on echo.",
                        )
                    ),
                    SubHeading("Management"),
                    Bullets(
                        listOf(
                            "High-dose NSAID or aspirin plus colchicine (0.5 mg once or twice daily for 3 months) \u2014 colchicine halves recurrence (ICAP trial).",
                            "Restrict strenuous activity until resolution.",
                            "Corticosteroids only for refractory / autoimmune / uraemic cases \u2014 low-to-moderate dose.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Cardiac tamponade",
                listOf(
                    Paragraph(
                        "Rapid or large effusion raises intrapericardial pressure above diastolic filling pressure, compromising venous return and cardiac output."
                    ),
                    SubHeading("Clinical features \u2014 Beck's triad"),
                    Bullets(
                        listOf(
                            "Hypotension.",
                            "Muffled heart sounds.",
                            "Raised JVP with absent Y descent.",
                            "Pulsus paradoxus > 10 mmHg (drop in systolic BP with inspiration).",
                            "Echo: diastolic RV collapse, systolic RA collapse, plethoric IVC.",
                        )
                    ),
                    SubHeading("Management"),
                    Numbered(
                        listOf(
                            "Urgent pericardiocentesis \u2014 echo-guided at the bedside for unstable patients; surgical drainage if loculated, post-surgical or traumatic haemopericardium.",
                            "Aggressive IV fluids as a bridge; avoid positive-pressure ventilation which may worsen haemodynamics.",
                            "Treat underlying cause and monitor for re-accumulation.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Acute haemopericardium \u2014 type-A aortic dissection until proven otherwise; do not perform pericardiocentesis before urgent CT and surgical consultation unless life-threatening.",
                    ),
                ),
            ),
            TopicSection(
                "Constrictive pericarditis",
                listOf(
                    Bullets(
                        listOf(
                            "Chronic fibrous/calcific thickening of pericardium restricts diastolic filling.",
                            "Causes: post-viral, post-cardiac surgery, radiation, TB (leading global cause), uraemia, connective tissue disease.",
                            "Features: fatigue, dyspnoea, ascites out of proportion to pulmonary oedema, raised JVP with prominent X and Y descents, Kussmaul sign, pericardial knock, pulsatile hepatomegaly.",
                            "Imaging: pericardial thickening > 2 mm on CT/MRI; septal bounce; discordant respiratory ventricular interaction; preserved LV size/function.",
                            "Medical therapy (diuretics, treat underlying cause) is a bridge; definitive treatment is pericardiectomy.",
                        ),
                        source = TopicSource.Davidson,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Colchicine for 3 months with NSAIDs halves pericarditis recurrence \u2014 do not forget it.",
            "Steroid early in pericarditis \u2192 more recurrences \u2014 avoid unless refractory or autoimmune.",
            "Beck\u2019s triad is only ~40 % sensitive; suspect tamponade whenever hypotension accompanies raised JVP.",
            "Pulsus paradoxus also occurs in severe asthma, COPD, severe hypovolaemia, and tension pneumothorax.",
            "Constriction vs restriction: imaging for pericardial thickening; respiratory ventricular interdependence favours constriction.",
            "Type-A dissection can mimic tamponade \u2014 CT first, surgeon on the way, avoid solo pericardiocentesis.",
            "Dressler syndrome: pericarditis + fever + pleural effusion 2\u20136 weeks post-MI; treat with NSAID + colchicine.",
        ),
        qna = listOf(
            QnA(
                "Fit 25-year-old, fever and pleuritic chest pain relieved by leaning forward; ECG diffuse ST\u2191 with PR depression \u2014 management?",
                "NSAID (ibuprofen) or aspirin plus colchicine 0.5 mg BD for 3 months. Restrict exertion.",
            ),
            QnA(
                "Hypotensive woman with raised JVP, muffled heart sounds, pulsus paradoxus 22 mmHg, echo shows RV collapse \u2014 what next?",
                "Urgent pericardiocentesis (surgical if post-cardiac-surgery or dissection suspected). Fluid resuscitation as a bridge.",
            ),
            QnA(
                "Chronic dyspnoea, marked ascites, Kussmaul sign, CT shows calcified pericardium \u2014 treatment?",
                "Pericardiectomy \u2014 diuretics provide only symptomatic relief in constrictive pericarditis.",
            ),
        ),
    )

    private val dissection = Topic(
        id = "card-dissection",
        title = "Aortic Dissection",
        subtitle = "Stanford A and B",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 279 \u2014 Diseases of the aorta"),
            TopicReference("Davidson 24e", "Ch. 16 \u2014 Cardiovascular disease (Aortic dissection)"),
        ),
        sections = listOf(
            TopicSection(
                "Classification & risk factors",
                listOf(
                    Paragraph(
                        "Aortic dissection is a tear in the intima that allows blood to enter a false lumen within the media. The Stanford classification divides dissections by whether the ascending aorta is involved (type A \u2014 surgical emergency) or not (type B \u2014 usually medical therapy first)."
                    ),
                    Bullets(
                        listOf(
                            "Hypertension is the dominant risk factor (~75 %).",
                            "Connective-tissue disease (Marfan, Ehlers\u2013Danlos type IV, Loeys\u2013Dietz).",
                            "Bicuspid aortic valve, coarctation, previous aortic surgery.",
                            "Pregnancy (especially third trimester), cocaine or amphetamine use, weight-lifting, chest trauma.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Clinical features",
                listOf(
                    Bullets(
                        listOf(
                            "Sudden, severe \u2018tearing\u2019 chest or back pain \u2014 maximal at onset.",
                            "Blood-pressure differential > 20 mmHg between arms.",
                            "New aortic regurgitation murmur; pericardial rub; diastolic murmur.",
                            "Malperfusion: stroke, paraplegia, ischaemic limb, mesenteric ischaemia, AKI.",
                            "Tamponade in type A with proximal extension; haemothorax in rupture.",
                        )
                    ),
                    SubHeading("Investigations"),
                    Bullets(
                        listOf(
                            "CT angiography of chest/abdomen/pelvis \u2014 first-line in stable patients.",
                            "Transoesophageal echocardiography \u2014 best for unstable patients or intraoperative.",
                            "D-dimer \u2014 highly sensitive; negative helps rule out if clinical probability low.",
                            "Bedside CXR: widened mediastinum (> 8 cm), abnormal aortic contour, pleural effusion.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "Management",
                listOf(
                    SubHeading("Initial medical therapy"),
                    Numbered(
                        listOf(
                            "Control heart rate first: IV beta-blocker (esmolol or labetalol) targeting HR < 60 bpm.",
                            "Then reduce systolic BP to 100\u2013120 mmHg with IV nitroprusside, clevidipine or nicardipine.",
                            "Treat pain with IV opioids \u2014 pain relief reduces sympathetic surge.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    SubHeading("Definitive therapy"),
                    Bullets(
                        listOf(
                            "Type A (ascending involvement): emergency surgery \u2014 aortic root / ascending aorta replacement \u00b1 valve.",
                            "Type B (descending aorta only): medical therapy first; TEVAR or surgery for complications (malperfusion, rupture, refractory pain/hypertension, rapid aortic expansion).",
                            "Long-term: lifelong BP control (ideally < 130/80), usually beta-blocker + ARB; surveillance imaging at 1, 3, 6 and 12 months then annually.",
                        )
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Do not give vasodilators before adequate beta-blockade \u2014 reflex tachycardia increases shear stress and extends the dissection.",
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "\u2018Tearing\u2019, maximal-at-onset chest or back pain should always prompt CT aorta.",
            "Control heart rate before BP in dissection (beta-blocker first, then vasodilator).",
            "Type A dissection mortality is ~1 %/hour without surgery \u2014 do not delay transfer.",
            "New AR murmur + chest pain = type A dissection until proven otherwise.",
            "D-dimer < 500 ng/mL is useful to rule out dissection when pretest probability is low (not high).",
            "TEVAR is reshaping type B management \u2014 now preferred for complicated type B.",
            "Lifelong beta-blocker + ARB + BP target < 130/80 reduces late complications.",
            "Marfan / Loeys-Dietz pregnancy: high risk of dissection in third trimester \u2014 surveillance imaging and delivery planning.",
        ),
        qna = listOf(
            QnA(
                "Tearing chest pain with BP 180/100 right arm and 140/80 left arm \u2014 first IV drug?",
                "IV beta-blocker (esmolol or labetalol) to achieve HR < 60 bpm; then add IV nitroprusside/clevidipine for BP to 100\u2013120 systolic.",
            ),
            QnA(
                "Stable type B dissection without malperfusion \u2014 management?",
                "Medical therapy (HR + BP control) in a critical-care setting; intervene if complications (malperfusion, rupture, refractory pain/hypertension, rapid expansion).",
            ),
            QnA(
                "Which imaging is best for suspected dissection in an unstable patient?",
                "Transoesophageal echocardiography at the bedside \u2014 faster and does not need contrast.",
            ),
        ),
    )

    val all: List<Topic> = listOf(stableIhd, valvular, cardiomyopathies, pericardial, dissection)
}
