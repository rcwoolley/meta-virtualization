DESCRIPTION = "Virtual Machine Manager"
HOMEPAGE = "http://www.virt-manager.org/"
LICENSE = "GPLv2+"

DEPENDS = "intltool virtual/gettext"

RDEPENDS_${PN} = "${PN}-common python-pygobject gtk+3 vte dconf dbus gtk-vnc spice-gtk"
# TODO: Add libvirt-glib"
RDEPENDS_${PN}-common = "libvirt-python libxml2-python python-urlgrabber python-ipaddr"
# TODO: Add libosinfo to common
RDEPENDS_virt-install = "python ${PN}-common"

PR = "r0"

inherit distutils python-dir

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PACKAGES += "${PN}-common virt-install"

FILES_${PN}-common = "${datadir}/${PN}/virtcli \
                      ${datadir}/${PN}/virtconv \
                      ${datadir}/${PN}/virtinst \
                      ${PYTHON_SITEPACKAGES_DIR}"

FILES_virt-install += "${bindir}/virt-clone \
                       ${bindir}/virt-convert \
                       ${bindir}/virt-install \
                       ${bindir}/virt-xml \
                       ${datadir}/man/man1/virt-clone.1.gz \
                       ${datadir}/man/man1/virt-convert.1.gz \
                       ${datadir}/man/man1/virt-install.1.gz \
                       ${datadir}/man/man1/virt-xml.1.gz \
                       ${datadir}/${PN}/virt-clone \
                       ${datadir}/${PN}/virt-convert \
                       ${datadir}/${PN}/virt-install \
                       ${datadir}/${PN}/virt-xml"


FILES_${PN} = "${bindir}/${PN} \
                ${mandir}/man1/*.1* \
                ${datadir}/${PN}/ui/*.ui \
                ${datadir}/${PN}/virt-manager \
                ${datadir}/${PN}/virtManager \
                ${datadir}/${PN}/icons \
                ${datadir}/icons/hicolor/*/apps/* \
                ${datadir}/appdata/${PN}.appdata.xml \
                ${datadir}/applications/${PN}.desktop \
                ${datadir}/glib-2.0/schemas/org.virt-manager.virt-manager.gschema.xml"

    

SRC_URI = "http://virt-manager.org/download/sources/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "baf6eaa88b02bdd7a3c2fdd293eeb6ac"
SRC_URI[sha256sum] = "ab0906cb15a132f1893f89ac4ca211c6c2c9c2d1860fbc285edbf9451c0f7941"

SRC_URI += "file://disable_myinstall.patch"

do_install_append() {
	rmdir ${D}${PYTHON_SITEPACKAGES_DIR}
