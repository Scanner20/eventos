package com.evento.apptallerautoridad.view

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterExpositor
import com.evento.apptallerautoridad.model.Expositor
import com.evento.apptallerautoridad.viewmodels.ExpositorViewModel
import kotlinx.android.synthetic.main.expositor_fragment.*

class ExpositorFragment : Fragment() {

    companion object {
        fun newInstance() = ExpositorFragment()
    }

    private val lista = arrayListOf<Expositor>()
    private lateinit var adapter: AdapterExpositor

    private lateinit var viewModel: ExpositorViewModel

    var options: NavOptions? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.expositor_fragment, container, false)

        showToolbar(view, "Expositores")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpositorViewModel::class.java)

        val toolbar = activity?.findViewById<Toolbar>(R.id.collapsing_toolbar_expositores)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        activity?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                options = navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                        popEnter = R.anim.slide_in_left
                        popExit = R.anim.slide_out_right
                    }
                }
            }

            adapter = AdapterExpositor(lista) { expositorItem: Expositor -> eventoItemClicked(expositorItem) }

            rcViewExpositores.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@ExpositorFragment.adapter
            }

            llenarExpositores()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as AppCompatActivity?
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun llenarExpositores() {
        lista.clear()

        lista.add(Expositor(17, "Edgar", "Patiño Garrido", "Presidente del Directorio", "Autoridad Portuaria Nacional", "Nació el 14 de octubre de 1956 en Lima, Perú. " +
                "Oficial de Marina en retiro, con Título profesional en Ciencias Marítimas, con estudios de Maestría en Economía y en Realidad Nacional, Defensa y Desarrollo. Con más de 30 años laborando en entidades públicas vinculadas a actividades marítimas, en las áreas funcionales de planeamiento, presupuesto, operacionales, económica-financiera y administrativa. " +
                "Ha desarrollado su actividad laboral con gestión orientada a optimizar procesos, mejorando el servicio al cliente, reduciendo costos de operación y generando mayor rentabilidad y productividad. " +
                "Experiencia en presupuesto público y administración de recursos económicos financieros. En los últimos once (11) años enfocado a la gestión de la planificación y ejecución de Proyectos de Inversión Pública-Privada en áreas Portuaria y de Transporte. \n" +
                "Actualmente ocupa el cargo de presidente del Directorio de la Autoridad Portuaria Nacional (APN)."))

        lista.add(Expositor(1, "Guillermo", "Bouroncle Calixto", "Gerente General ", "Autoridad Portuaria Nacional", "Abogado por la Universidad Católica del Perú y Máster en Derecho Marítimo Internacional por el Instituto de Derecho Marítimo Internacional de la OMI en Malta. " +
                "Postgrado en Asociaciones Público-Privadas de Servicios Públicos Regulados por la Universidad del Pacífico. Experiencia en el sistema portuario, marina mercante, Derecho del Mar, operaciones navales y guardacostas, y derecho administrativo. Ha sido asesor legal de la Dirección General de Transporte Acuático del Ministerio de Transportes y Comunicaciones, de la Dirección General de Capitanías y Guardacostas y del Comandante General de la Marina. Ha sido profesor de Derecho Marítimo Internacional en la Escuela Naval del Perú y del programa de Maestría en Administración Marítima, Portuaria y Pesquera de la Escuela Nacional de Marina Mercante. Representante Alterno de Perú ante la Comisión Interamericana de Puertos de la OEA; representante de Perú ante la Conferencia Diplomática de las Naciones Unidas / OMI para la Convención Internacional sobre el Arresto de Buques; Representante de Perú ante el Comité Andino de Autoridades de Transporte Acuático de la Comunidad Andina de Naciones. " +
                "Autor del Libro “Influencia de las Islas en la Delimitación Marítima”, editorial Lambert de Alemania"))

        lista.add(Expositor(2, "Luis", "García Lumbreras", "Jefe de la Unidad de Protección y Seguridad", "Autoridad Portuaria Nacional" , "Es titulado como Oficial de Marina Mercante, con estudios de Maestría en la especialidad de “Administración Marítima Portuaria y de Pesca” y en “Gestión de Recursos Humanos y Calidad”, siguió un diplomado en Contrataciones de Asociación Publico Privado, con experiencia laboral a cargo de diferentes unidades y dependencias navales de la Marina de Guerra del Perú, también cuenta con experiencia en los cargos de Director de Capacitación, Asesor Académico e Instructor de Cursos OMI de la Escuela Nacional de Marina Mercante y desde el año 2016 forma parte de la Autoridad Portuaria Nacional y actualmente ocupa el cargo de Jefe de la Unidad de Protección y Seguridad (UPS), asimismo se desempeñó como docente de la facultad de ingeniería marítima de la Universidad Tecnológica del Perú."))

        lista.add(Expositor(3, "Prefecto General (R)", "Sr. René Vicente Reibel", "Experto RED PBIP México Internacional", "RED PBIP México Internacional", "Integrante de la Prefectura Naval Argentina, revistando como Oficial Superior Retirado, con el grado máximo de Prefecto General, siendo Designado “Director de Policía Judicial, Protección Marítima y Puertos” durante los años 2016 y 2017 y Jefe de Unidad de Policías de las Américas (AMERIPOL) en Representación de esa Fuerza de Seguridad.\n" +
                "\n" +
                "También ocupó el Cargo de “Jefe del Departamento Investigaciones del Narcotráfico”, Participando activamente en reuniones internacionales del Grupo de Expertos de la Comisión Interamericana para el Control del Abuso de Drogas (CICAD – OEA) Sobre Narcotráfico Marítimo en su sede en Washington (EE.UU.) y diferentes Países de Latinoamérica.\n" +
                "\n" +
                "Actualmente es ASESOR de las Comisiones de “Intereses Marítimos, Fluviales, Pesqueros y Portuarios” y “Seguridad Interior” de la Honorable Cámara de Diputados de la Nación, del “Ente Binacional CARU” (Comisión Administradora del Río Uruguay) y del “Sindicato Único de Serenos de Buques de la República Argentina”; dando conferencias sobre “Problemática del Avance del Narcotráfico en la República Argentina” en diferentes ciudades del interior de ese país. \n" +
                "Como ASESOR y EXPERTO de la “RED PBIP MÉXICO INTERNACIONAL” a disertado en Foros Internacionales sobre “Protección y Seguridad Marítima y Portuaria”.\n" +
                "\n" +
                "Cursó Estudios de Grado como “Licenciado en Ciencias Políticas y Gobierno” en la Universidad Nacional de Lanús y “Licenciado en Seguridad Marítima” en el Instituto Universitario en Seguridad Marítima de la Prefectura Naval Argentina. Realizó “Curso de Postgrado de Seguridad y Derecho” en la Pontificia Universidad Católica Argentina.\n" +
                "\n" +
                "En octubre de 2015 recibió la Distinción “Cruz al Mérito Policial con Distintivo Blanco” otorgada por el Ministerio del Interior del Reino de España."))

        lista.add(Expositor(4, "Menotti", "Yáñez Ramírez", "Director", "INFOCAP – ENAPU S.A", "Es licenciado en educación con especialidad en Ciencias Históricos Sociales y Filosofía y Gestión de la Educación, con maestría en recursos humanos y Post Grado de especialización en Administración, especialización en Dirección y Gestión Educativa, Planificación y Gestión Portuaria, XIV Curso Iberoamericano de Gestión Portuaria CIP OEA/PUERTOS DEL ESTADO, MADRID ESPAÑA 2009 Procesos Logísticos, " +
                "Florida International University 2015, con estudios en protección portuaria Curso Port State Control – APN-OEA-CUBIC 2010, Port Facility Security Officer APN-OEA-CUBIC 2010, Train the Trainer - APN-OEA-CUBIC 2010, Básico II PBIP 2011, OPIP –APN 2012, Taller Manual de Ejercicios y Practicas de Protección Portuaria - Julio 2012, OPIP –APN 2012, entre otros. También llevo cursos de Auditor BASC – BASC 2014, Auditor Internacional BASC 2014, Auditor de Sistemas de Gestión OHSAS 18001:2007 - Bureau veritas 2015. Actualmente se desempeña como docente en el Instituto Peruano de Acción Empresarial – IPAE Filial Iquitos, Docente en la Universidad Privada del Oriente, Docente del Centro de Instrucción Fluvial AC Iquitos, Instructor Autorizado en Protección Portuaria, Instructor Autorizado en Seguridad Portuaria, Instructor en Mercancías Peligrosas – INFOCAP, Instructor Autorizado en Escuela Básica del CGBVP e Instructor de Instructores CGBVP"))

        lista.add(Expositor(5, "Olivio", "Huancaruna Perales", "Presidente", "Cámara de Comercio y Producción de Lambayeque", "Cofundador y director de ALTOMAYO PERÚ S.A.C. y Cofundador y Director del GRUPO PERHUSA y actual Presidente de la Cámara de Comercio y Producción de Lambayeque"))

        lista.add(Expositor(6, "Guillermo", "Acosta Rodriguez", "Gerente General", "Asociación Marítima del Perú - ASMARPE" , "Oficial de Marina Mercante, con estudios de maestría en administración y diplomado sobre Sistemas Integrados de Gestión, actualmente es Gerente General de la Asociación Marítima del Perú – ASMARPE."))

        lista.add(Expositor(7, "Juan Carlos", "Portocarrero Zamora", "Director General Contra el Crimen Organizado", "Ministerio del Interior",
                "Abogado de profesión, con 25 años de experiencia, se ha desempeñado como asesor de la Comisión Nacional Revisora del Código Penal, de la que luego fue miembro como representante alterno del Colegio de Abogados de Lima (CAL). " +
                        "Ha destacado en la lucha contra el crimen organizado y la corrupción desde la Procuraduría Anticorrupción Ad Hoc, en la que se desempeñó como procurador adjunto a cargo de casos emblemáticos, como los del Estado contra el ex presidente Alberto Fujimori y su asesor Vladimiro Montesinos. Compilador y autor de artículos sobre Crimen Organizado, el actual director general contra el Crimen Organizado ha escrito y publicado el “Compendio de Política Criminal y  Criminalidad Organizada” en el 2015, así como “Guía Práctica de la Ley contra el Crimen Organizado, Ley 30077”, en el mismo año. Se ha desempeñado como catedrático de Derecho en las escuelas de Pre-Grado y Post-Grado de distintas universidades del país, y en la Academia de la Magistratura. Asimismo, ha participado en el desarrollo de conferencias de Derecho Penal y Procesal Penal tanto en el país como en el extranjero, y como capacitador de la escuela del Ministerio Publico y de la Dirección Nacional de Asuntos Jurídicos del Ministerio de Justicia. Cuenta con estudios de doctorado en Derecho Penal en la Universidad de Salamanca (España) y una maestría en Ciencias Penales en la Universidad Particular San Martín de Porres (Lima)"))

        lista.add(Expositor(8, "Salvattore Leonardo", "Tripi Rossel", "Director Contra Delitos de Crimen Organizado", "Ministerio del Interior" , "Abogado, con maestría en derecho procesal penal con mención en destrezas y técnicas de litigación oral, actualmente es Director de la Dirección Contra Delitos de Crimen Organizado de la Dirección General Contra el Crimen Organizado del Ministerio del Interior."))

        lista.add(Expositor(9, "Alvaro Eloy", "Rodriguez Chavez", "Dirección de Facilitación del Comercio Exterior", "Ministerio de Comercio Exterior y Turismo", "Magister en Supply Chain Management por la Universidad del Pacifico, Ingeniero Comercial con especialidad en Negocios Internacionales, amplia experiencia en actividades de comercio exterior, logística internacional y aduanas tanto en el sector Público como en el privado, actualmente funcionario de la Dirección de Facilitación de Comercio Exterior del Viceministerio de Comercio Exterior"))

        lista.add(Expositor(10, "Juan Manuel", "Carrasco Millones", "Fiscal Provincial", "Fiscalía especializada contra la criminalidad organizada de Chiclayo" , "Abogado por la Universidad Nacional Pedro Ruiz Gallo de Lambayeque, especialista en Aduanas y Comercio Internacional por la SUNAT y Magister en Derecho por la Universidad Privada de Piura. Tiene experiencia laboral como abogado en la defensa libre en la ciudad de Chiclayo, desde el año 2002 hasta el año 2004, laboró en calidad de Especialista en Aduanas y representante de la Procuraduría Pública de SUNAT – Aduanas, en diversas aduanas del Perú. Desde el año 2010, ocupó el Cargo de Fiscal Adjunto Provincial de la Tercera Fiscalía Provincial Penal de Chiclayo – Lambayeque, en el Cuarto Despacho de Investigación, a cargo de la mayoría de investigaciones por delito de Extorsión, Asociación Ilícita y Homicidio Calificado en la ciudad de Chiclayo. \n" +
                "Entre los casos emblemáticos inicio investigaciones contra las organizaciones LA GRAN FAMILIA, LOS SICARIOS DEL NORTE, LOS INJERTOS DEL NORTE, LOS LIMPIOS DE LA CORRUPCIÓN Y LOS WACHITURROS DE TUMAN.\n" +
                "Fiscal Provincial Provisional de la Fiscalía Anticorrupción de la ciudad de Chiclayo desde el 12 de Diciembre de 2014 hasta el 29 de abril de 2015.\n" +
                "Fiscal Provincial Penal Titular Corporativo de la Tercera Fiscalía Provincial Penal Corporativa de Chiclayo y Fiscal Coordinador de la Tercera Fiscalía Provincial Penal Corporativa de Chiclayo desde el mayo de 2015 hasta mayo de 2016.\n" +
                "Desde Junio del año 2016 hasta la actualidad se desempeña como FISCAL PROVINCIAL PENAL EN EL DESPACHO DE LA FISCALIA CONTRA LA CRIMINALIDAD ORGANIZADA."))

        lista.add(Expositor(11, "Denis", "Romani Seminario",
                "Representante de la Unidad de Inteligencia Financiera - UIF",
                "Superintendencia de Banca, Seguros y AFP - SBS",
                "Abogado por la Facultad de Derecho y Ciencias Políticas de la Universidad Nacional de Piura. Con estudios de Maestría en Derecho Penal por la Pontificia Universidad Católica del Perú. \n" +
                        "\tCertificado por el Grupo de Acción Financiera de Latinoamérica (GAFILAT) como evaluador de países en el cumplimiento de las Recomendaciones del Grupo de Acción Financiera Internacional (GAFI) sobre el blanqueo de capitales y la efectividad de los sistemas anti lavado de activos y contra la financiación del terrorismo (ALA/CFT).\n" +
                        "\tActualmente, Analista del Área Penal del Departamento de Análisis Operativo de la Unidad de Inteligencia Financiera del Perú (UIF-Perú) y participa en la aplicación, ejecución y defensa judicial de los congelamientos administrativos de fondos dispuestos por la UIF-Perú en investigaciones administrativas y fiscales por casos de lavado de activos.\n" +
                        "\tFue Comisionado de la Adjuntía para los Asuntos Constitucionales de la Defensoría del Pueblo de Perú (Ombudsman Perú) a cargo las líneas de trabajo de seguridad ciudadana y acceso a la justicia. Apoderado procesal de la Defensoría del Pueblo en los procesos constitucionales que ha intervenido como demandante o como partícipe a traves de amicus curiae.\n" +
                        "\tFue Secretario de la Oficina Desconcentrada de Control de la Magistratura de Piura y asesor en Juzgados y Salas Superiores Especializadas en lo Penal."))

        lista.add(Expositor(12, "Jaime", "Navach Gamio", "Director de Desarrollo de Negocios", "GN7 Investment Group", "Oficial de Marina con experiencia (Contralmirante en situación de retiro), asumiendo altas responsabilidades en puestos de confianza, conferidas por el nivel de jerarquía más alto de la Marina de Guerra del Perú y del Ministerio de Defensa. Magister/Maestro en Estrategia Marítima. Asesor y Consultor empresarial independiente. Asesorías y Consultorías en diversos temas empresariales y de Gestión de Riesgo de Desastres (GRD)."))

        lista.add(Expositor(13, "Carolina", "Gonzalez Mejia", "Consultora Seniur", "STRATEGY SECURITY S.A.C", "CEO en STRATEGY SECURITY S.A.C, especialista en implementación de Tecnología Avanzada para Seguridad Especializada. 12 años de Experiencia en el Sector de La Seguridad y Tecnología en diferentes empresas de Latinoamérica como Gerente General y Directora Comercial. Trayectoria en Perú desde el 2007, involucrada en proyectos de Seguridad Aeroportuarios, de aduanas, militares, entre otros; especializada en contrataciones con el estado y recientemente promoviendo la implementación de Ciberseguridad y Seguridad Sicológica"))

        lista.add(Expositor(14, "Fernando", "Huarcaya Ugarte", "Delegado", "RED PBIP MEXICO Internacional" , "Ingeniero de profesión, actualmente es delegado de la RED PBIP México Internacional"))

        lista.add(Expositor(15, "Miguel", "Hidalgo Medina", "Gerente General", "MINALGO SAC", "Ex Ministro de Estado en el despacho del Interior, Teniente General – Director General de la Policía Nacional del Perú, con más de 36 años de experiencia en Políticas Públicas de Seguridad, Seguridad Ciudadana, Crimen Organizado, Inteligencia y Conflictividad Social. Ha desarrollado liderazgo comprobado en todos los cargos que le ha tocado desempeñar, con formación académica, Magister en Gestión Pública y Catedrático Universitario. " +
                "En la Policía Nacional de Perú alcanzó la más alta jerarquía de la Institución y ocupó los más altos cargos del Escalafón Policial como: Director General, Jefe del Estado Mayor General e Inspector General. Fue Jefe Policial de la Macro Región Ayacucho - Ica; cobra singular relevancia su desempeño como Director Antidrogas (DIRANDRO), período en el cual se hicieron importantes avances en la lucha contra las drogas, desarrollando e implementando procedimientos especiales de investigaciones para la lucha contra lavado de activos, otro de sus logros más importantes, la implementación de la Plataforma Tecnológica “Constelación” para la escucha legal. " +
                "Gran experticia, en la prevención y resolución de Conflictos Sociales, generando condiciones óptimas de seguridad para las empresas que desarrollan proyectos en el país"))

        lista.add(Expositor(16, "Javier", "Reategui Bastas", "Jefe de la Dirección de Inteligencia DIVPAD", "Policía Nacional del Perú", "Comandante de la Policía Nacional del Perú, Actualmente se desempeña como Jefe de Sección de Inteligencia de la División Portuaria Antidrogas DIVPAD – DIRANDRO. Asimismo, tuvo a cargo las siguientes Jefaturas: Unidad de Operaciones Especiales (GEIN-ESCORPION-DIRIAD-DIREJANDRO), Unidad de Operaciones Especiales  (GEIN-UNIOPES-“AE”), Unidad de “AE” Y “MDFH” (GEIN-UNIOPES-“AE”),  DINOES PNP - VRAEM. Cuenta con Especialización en Inteligencia Antidrogas, Lavado de Activos y Pérdida de Dominio. Catedrático integrante de instrucción de la ESANDRO-PNP, especializado en cursos de Analista en Contra Inteligencia Estratégico, Informática Aplicada a la Lucha Contra el TID, Investigación de Insumos Químicos y Productos Fiscalizados."))



        adapter.notifyDataSetChanged()
    }

    private fun eventoItemClicked(expositor: Expositor) {
        val bundle = bundleOf("id" to expositor.id,
                "nombre" to expositor.nombre,
                "apellido" to expositor.apellido,
                "cargo" to expositor.cargo,
                "empresa" to expositor.empresa,
                "resenia" to expositor.resenia)

        findNavController().navigate(R.id.detalleExpositorFragment, bundle, options)
    }

    private fun showToolbar(view: View, title: String) {
        val toolbar = view.findViewById<Toolbar>(R.id.collapsing_toolbar_expositores)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }
}
