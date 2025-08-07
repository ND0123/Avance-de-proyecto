package gimnasio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gimnasio {

    static Socio[] socios = new Socio[10];
    static Parqueo parqueo = new Parqueo();
    static CabinaInsonorizada[] cabina = new CabinaInsonorizada[9];
    static ClaseGrupal[] claseGrupal = new ClaseGrupal[6];
    static SalaPesas salaPesas = new SalaPesas();
    static boolean[][] mesas = new boolean[2][4];
    static int[] futbol = new int[2];
    static int baloncesto = 0;
    static int[] tenis = new int[2];

    public static void main(String[] args) {
        cargarSocios();
        CabinaInsonorizada.llenaDataAleatoria(cabina);

        // Mostrar la ventana principal en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainWindows mainWindow = new MainWindows();
            mainWindow.setTitle("Gimnasio");
            mainWindow.setLocationRelativeTo(null); // centra
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        // Ejecutar el menú en un hilo separado para no bloquear la GUI
        new Thread(Gimnasio::mostrarMenu).start();
    }

    private static void mostrarMenu() {
        int opcion = 0;
        do {
            String input = JOptionPane.showInputDialog(
                    "--- MENÚ PRINCIPAL ---\n"
                    + "1. Mostrar parqueos\n"
                    + "2. Buscar socio por ID\n"
                    + "3. Asignar un parqueo\n"
                    + "4. Cabinas insonorizadas\n"
                    + "5. Clases Grupales \n"
                    + "6. Ingresar a  sala de pesas\n"
                    + "7. Salir de sala de pesas\n"
                    + "8. Ver personas en sala de pesas\n"
                    + "9. Espacio de recreación\n"
                    + "10. Auditorio fitness\n"
                    + "0. Salir\n"        
                    + "Ingrese una opción:"
            );

            if (input == null) {
                break; // Cancelar ventana
            }
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    parqueo.mostrarTodo();
                    break;
                case 2:
                    String id = JOptionPane.showInputDialog("Ingrese ID del socio:");
                    Socio s = buscarSocio(id);
                    if (s != null) {
                        JOptionPane.showMessageDialog(null,
                                "Socio encontrado: " + s.getNombre() + " | Activo: " + s.isActivo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Socio no encontrado.");
                    }
                    break;
                case 3:
                    String idSocio = JOptionPane.showInputDialog("Ingrese ID del socio:");
                    Socio socio = buscarSocio(idSocio);

                    if (socio != null && socio.isActivo()) {
                        String nivel = JOptionPane.showInputDialog("Ingrese nivel de parqueo (G1, G2, G3):");

                        String filaInput = JOptionPane.showInputDialog("Ingrese fila (A-F):");
                        if (filaInput == null || filaInput.length() == 0) {
                            break;
                        }
                        char fila = Character.toUpperCase(filaInput.charAt(0));

                        String colInput = JOptionPane.showInputDialog("Ingrese columna (1-5):");
                        int columna;
                        try {
                            columna = Integer.parseInt(colInput);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Columna inválida.");
                            break;
                        }

                        boolean asignado = parqueo.asignarEspacio(nivel, fila, columna);
                        if (asignado) {
                            JOptionPane.showMessageDialog(null, "Parqueo asignado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo asignar el parqueo.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Socio no encontrado o inactivo.");
                    }
                    break;
                case 4:
                    int opcHorarioCabinas = CabinaInsonorizada.MostrarHorariosCabinas(cabina);
                    CabinaInsonorizada.reservarHorario(cabina, opcHorarioCabinas);
                    break;
                case 5:
                    ModuloClaseGrupales.ejecutar();
                    break;
                case 6:
                    String idIngreso = JOptionPane.showInputDialog(null, "Ingrese ID del socio para ingresar a sala de pesas:");
                    if (idIngreso != null) {
                        Socio socioIngreso = buscarSocio(idIngreso);
                        if (socioIngreso != null && socioIngreso.isActivo()) {
                            salaPesas.ingresar(idIngreso);
                            JOptionPane.showMessageDialog(null, "Ingreso exitoso para: " + socioIngreso.getNombre());
                        } else {
                            JOptionPane.showMessageDialog(null, "Socio no válido o no activo.");
                        }
                    }
                    ;
                    break;
                case 7:
                    String idSalida = JOptionPane.showInputDialog(null, "Ingrese ID del socio para salir de sala de pesas:");
                    if (idSalida != null) {
                        salaPesas.salir(idSalida);
                        JOptionPane.showMessageDialog(null, "Salida procesada para el ID: " + idSalida);
                    }
                    break;
                case 8:
                    int cantidad = salaPesas.getCantidadActual();
                    JOptionPane.showMessageDialog(null, "Personas en sala de pesas: " + cantidad);
                    break;
                case 9:
                    do {
                        String opcionRecreacion = JOptionPane.showInputDialog(
                                "----- ESPACIO DE RECREACIÓN -----\n"
                                + "1. Reservar mesa de ping-pong\n"
                                + "2. Reservar mesa de billar\n"
                                + "3. Ver disponibilidad mesas\n"
                                + "4. Ingresar a cancha de fútbol\n"
                                + "5. Ingresar a cancha de baloncesto\n"
                                + "6. Ingresar a cancha de tenis\n"
                                + "7. Ver estado de canchas\n"
                                + "8. Ingresar Auditorio Fitness\n"        
                                + "0. Volver al menú"
                        );
                        if (opcionRecreacion == null || opcionRecreacion.equals("0")) {
                            break;
                        }

                        switch (opcionRecreacion) {
                            case "1":
                            case "2": {
                                int tipoMesa = opcionRecreacion.equals("1") ? 0 : 1;
                                String turnoStr = JOptionPane.showInputDialog("Seleccione turno (1-4):");
                                try {
                                    int turno = Integer.parseInt(turnoStr) - 1;
                                    if (turno >= 0 && turno < 4) {
                                        if (!mesas[tipoMesa][turno]) {
                                            mesas[tipoMesa][turno] = true;
                                            JOptionPane.showMessageDialog(null, "Turno reservado exitosamente.");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Turno no disponible.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Turno inválido.");
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                                }
                                break;
                            }

                            case "3": {
                                StringBuilder sb = new StringBuilder("Disponibilidad de mesas:\n");
                                for (int i = 0; i < 4; i++) {
                                    sb.append("Turno ").append(i + 1).append(":\n");
                                    sb.append("  Ping-pong: ").append(mesas[0][i] ? "Reservado" : "Disponible").append("\n");
                                    sb.append("  Billar: ").append(mesas[1][i] ? "Reservado" : "Disponible").append("\n");
                                }
                                JOptionPane.showMessageDialog(null, sb.toString());
                                break;
                            }

                            case "4": {
                                String canchaStr = JOptionPane.showInputDialog("Ingrese número de cancha (1 o 2):");
                                try {
                                    int cancha = Integer.parseInt(canchaStr) - 1;
                                    if (cancha >= 0 && cancha < 2) {
                                        if (futbol[cancha] < 12) {
                                            futbol[cancha]++;
                                            JOptionPane.showMessageDialog(null, "Ingresado a cancha de fútbol " + (cancha + 1));
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cancha llena.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cancha inválida.");
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                                }
                                break;
                            }

                            case "5": {
                                if (baloncesto < 10) {
                                    baloncesto++;
                                    JOptionPane.showMessageDialog(null, "Ingresado a cancha de baloncesto.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cancha llena.");
                                }
                                break;
                            }

                            case "6": {
                                String canchaStr = JOptionPane.showInputDialog("Ingrese número de cancha de tenis (1 o 2):");
                                try {
                                    int cancha = Integer.parseInt(canchaStr) - 1;
                                    if (cancha >= 0 && cancha < 2) {
                                        if (tenis[cancha] < 2) {
                                            tenis[cancha]++;
                                            JOptionPane.showMessageDialog(null, "Ingresado a cancha de tenis " + (cancha + 1));
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cancha llena.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cancha inválida.");
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                                }
                                break;
                            }

                            case "7": {
                                String estado
                                        = "Fútbol:\n"
                                        + "  Cancha 1: " + futbol[0] + "/12 jugadores\n"
                                        + "  Cancha 2: " + futbol[1] + "/12 jugadores\n\n"
                                        + "Baloncesto:\n"
                                        + "  Cancha: " + baloncesto + "/10 jugadores\n\n"
                                        + "Tenis:\n"
                                        + "  Cancha 1: " + tenis[0] + "/2 jugadores\n"
                                        + "  Cancha 2: " + tenis[1] + "/2 jugadores";
                                JOptionPane.showMessageDialog(null, estado);
                                break;
                            }

                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } while (true);
                    break;
                case 10:
                    ModuloAuditorio.ejecutar(socios);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void cargarSocios() {
        socios[0] = new Socio("S001", "Carlos Gomez", true);
        socios[1] = new Socio("S002", "Ana Ruiz", true);
        socios[2] = new Socio("S003", "Luis Torres", false);
        socios[3] = new Socio("S004", "Maria Solis", true);
    }

    public static Socio buscarSocio(String id) {
        for (int i = 0; i < socios.length; i++) {
            if (socios[i] != null && socios[i].getId().equalsIgnoreCase(id)) {
                return socios[i];
            }
        }
        return null;
    }
}
